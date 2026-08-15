package my.jk.divelogpractices.common.log.writer;

import my.jk.divelogpractices.common.log.WebTraceLog;

public interface WebTraceLogMessageWriter {

    String generateRequestLog(WebTraceLog transactionLog);

    String generateResponseLog(WebTraceLog transactionLog);
}
