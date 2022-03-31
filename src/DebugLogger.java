import enums.LogLevel;

public class DebugLogger extends AbstractLogger {

    DebugLogger() {
        this.logLevel = LogLevel.DEBUG;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
       logSubject.notifyAllObservers(LogLevel.DEBUG, message);
    }
}
