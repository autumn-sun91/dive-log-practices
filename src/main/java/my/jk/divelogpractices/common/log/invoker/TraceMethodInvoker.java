package my.jk.divelogpractices.common.log.invoker;

import java.lang.reflect.Method;
import my.jk.divelogpractices.common.log.Trace;

public interface TraceMethodInvoker {
    Trace getTraceLog(Method invokeMethod);
}
