package my.jk.divelogpractices.config;

import my.jk.divelogpractices.common.log.TraceInfoManager;
import my.jk.divelogpractices.common.log.TraceLogAdvisorBuilder;
import my.jk.divelogpractices.common.log.WebTraceLog;
import my.jk.divelogpractices.common.log.filter.WebTraceLogFilter;
import my.jk.divelogpractices.common.log.filter.WebTraceLogFilterBeanBuilder;
import my.jk.divelogpractices.common.log.invoker.DefaultWebTraceMethodInvoker;
import org.springframework.aop.Advisor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class AppLogConfig {

    @Bean
    public TraceInfoManager<WebTraceLog>  traceInfoManager() {
        return new TraceInfoManager<>(WebTraceLog::new);
    }

    @Bean
    public Advisor traceLogAdvisor() {
        return new TraceLogAdvisorBuilder<WebTraceLog>()
                .traceInfoManager(traceInfoManager())
                .traceLogPointcutExpression(
                        "execution(* my.jk.divelogpractices..*Controller.*(..)) "
                                + "|| execution(* my.jk.divelogpractices..*Manager.*(..))")
                .build();
    }

    @Bean
    public FilterRegistrationBean<WebTraceLogFilter<WebTraceLog>> webTransactionLogFilter(
            RequestMappingHandlerMapping requestMappingHandlerMapping) {

        return new WebTraceLogFilterBeanBuilder<WebTraceLog>().traceInfoManager(traceInfoManager())
                .urlPatterns("/dive-resorts/*", "/dive-points/*", "/dive-logs/*")
                .webTraceLogLoader(new DefaultWebTraceMethodInvoker(requestMappingHandlerMapping))
                .applyOrder(Ordered.HIGHEST_PRECEDENCE).build();
    }
}
