package my.jk.divelogpractices.common.log.invoker;

import my.jk.divelogpractices.common.log.Trace;

import java.lang.reflect.Method;

public interface TraceMethodInvoker {
    Trace getTraceLog(Method invokeMethod);
}
