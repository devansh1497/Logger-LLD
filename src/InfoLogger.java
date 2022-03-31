import enums.LogLevel;

public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        this.logLevel = LogLevel.INFO;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        String msg = "INFO: " + message;
        logSubject.notifyAllObservers(LogLevel.INFO, msg);
    }
}
