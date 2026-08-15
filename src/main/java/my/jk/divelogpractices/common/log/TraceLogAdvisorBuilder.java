package my.jk.divelogpractices.common.log;

import my.jk.divelogpractices.common.log.invoker.DefaultTraceMethodInvoker;
import my.jk.divelogpractices.common.log.invoker.TraceMethodInvoker;
import my.jk.divelogpractices.common.log.writer.DefaultTraceLogMessageWriter;
import my.jk.divelogpractices.common.log.writer.TraceLogMessageWriter;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.core.Ordered;
import org.springframework.util.Assert;

import static java.util.Objects.nonNull;

public class TraceLogAdvisorBuilder<T extends TraceLog> {

    private String traceLogPointcutExpression;
    private TraceInfoManager<T> traceInfoManager;
    private TraceMethodInvoker traceMethodInvoker;
    private TraceLogMessageWriter traceLogMessageWriter;
    private Integer applyOrder;

    public TraceLogAdvisorBuilder<T> traceLogPointcutExpression(String traceLogPointcutExpression) {
        this.traceLogPointcutExpression = traceLogPointcutExpression;
        return this;
    }

    public TraceLogAdvisorBuilder<T> traceInfoManager(TraceInfoManager<T> traceInfoManager) {
        this.traceInfoManager = traceInfoManager;
        return this;
    }

    public TraceLogAdvisorBuilder<T> traceLogLoader(TraceMethodInvoker traceLogLoader) {
        this.traceMethodInvoker = traceLogLoader;
        return this;
    }

    public TraceLogAdvisorBuilder<T> traceLogMessageGenerator(TraceLogMessageWriter traceLogMessageWriter) {
        this.traceLogMessageWriter = traceLogMessageWriter;
        return this;
    }

    public TraceLogAdvisorBuilder<T> applyOrder(int applyOrder) {
        this.applyOrder = applyOrder;
        return this;
    }

    public Advisor build() {
        Assert.notNull(traceInfoManager, "traceInfoManager required.");
        if (traceMethodInvoker == null) {
            traceMethodInvoker = new DefaultTraceMethodInvoker();
        }
        if (traceLogMessageWriter == null) {
            traceLogMessageWriter = new DefaultTraceLogMessageWriter();
        }
        if (applyOrder == null) {
            applyOrder = Ordered.HIGHEST_PRECEDENCE + 1;
        }

        ComposablePointcut pointcut = new ComposablePointcut(new AnnotationMatchingPointcut(Trace.class));
        pointcut.union(new AnnotationMatchingPointcut(null, Trace.class));

        if(nonNull(traceLogMessageWriter)) {
            AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
            expressionPointcut.setExpression(traceLogPointcutExpression);
            pointcut.union((Pointcut) expressionPointcut);
        }

        TraceLogMethodInterceptor<T> methodInterceptor = new TraceLogMethodInterceptor<>(
                traceInfoManager,
                traceMethodInvoker,
                traceLogMessageWriter);

        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(pointcut, methodInterceptor);
        pointcutAdvisor.setOrder(applyOrder);
        return pointcutAdvisor;
    }
}
