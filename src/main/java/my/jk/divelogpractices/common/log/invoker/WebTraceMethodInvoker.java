package my.jk.divelogpractices.common.log.invoker;

import jakarta.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import my.jk.divelogpractices.common.log.WebTrace;

public interface WebTraceMethodInvoker {

    Method getTargetMethod(HttpServletRequest request);

    WebTrace getWebTrace(Method apiMethod);
}
