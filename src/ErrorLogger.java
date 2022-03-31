import enums.LogLevel;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.logLevel = LogLevel.ERROR;
    }

    @Override
    protected void display(String message, LogSubject logSubject)
    {
        String msg = "ERROR: "+message;
        logSubject.notifyAllObservers(LogLevel.ERROR, msg);
    }
}
