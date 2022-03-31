import enums.LogLevel;

public class LogManager {

    public static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger debugLogger = new DebugLogger();

        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);

        return infoLogger;
    }

    public static LogSubject buildSubject() {
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        logSubject.addObserver(LogLevel.INFO, consoleLogger);
        logSubject.addObserver(LogLevel.ERROR, fileLogger);
        logSubject.addObserver(LogLevel.ERROR, consoleLogger);
        return logSubject;
    }
}
