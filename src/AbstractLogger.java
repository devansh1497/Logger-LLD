import enums.LogLevel;

public abstract class AbstractLogger {

    LogLevel logLevel;
    AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(LogLevel logLevel, String message, LogSubject logSubject) {
        if(this.logLevel.id >= logLevel.id) {
            display(message, logSubject);
        }
        if(this.nextLogger != null) {
            this.nextLogger.logMessage(logLevel, message, logSubject);
        }
    }

    protected abstract void display(String message, LogSubject logSubject);
}
