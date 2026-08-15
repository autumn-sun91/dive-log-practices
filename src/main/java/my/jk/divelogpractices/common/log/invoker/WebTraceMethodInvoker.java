package my.jk.divelogpractices.common.log.invoker;

import jakarta.servlet.http.HttpServletRequest;
import my.jk.divelogpractices.common.log.Trace;
import my.jk.divelogpractices.common.log.WebTrace;

import java.lang.reflect.Method;

public interface WebTraceMethodInvoker {

    Method getTargetMethod(HttpServletRequest request);

    WebTrace getWebTrace(Method apiMethod);
}
