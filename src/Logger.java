import enums.LogLevel;

public class Logger {

    private static volatile Logger instance;
    private static AbstractLogger chainOfLogger;
    private static LogSubject logSubject;

    private Logger() {}

    public static Logger getInstance() {
        if(instance == null) {
            synchronized (Logger.class) {
                if(instance == null) {
                    instance = new Logger();
                    chainOfLogger = LogManager.buildChainOfLogger();
                    logSubject = LogManager.buildSubject();
                }
            }
        }
        return instance;
    }

    private void createLog(LogLevel logLevel, String message) {
        chainOfLogger.logMessage(logLevel, message, logSubject);
    }

    public void info(String message) {
        createLog(LogLevel.INFO, message);
    }

    public void debug(String message) {
        createLog(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        createLog(LogLevel.ERROR, message);
    }
}

