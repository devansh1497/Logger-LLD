import enums.LogLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {

    Map<LogLevel, List<Sink>> logLevelToSinks = new HashMap<>();

    public void addObserver(LogLevel logLevel, Sink sink) {
        List<Sink> observers = this.logLevelToSinks.getOrDefault(logLevel, new ArrayList<>());
        observers.add(sink);
        this.logLevelToSinks.put(logLevel, observers);
    }

    public void notifyAllObservers(LogLevel logLevel, String message) {
        for(Map.Entry<LogLevel, List<Sink>> entry : logLevelToSinks.entrySet()) {
            if(entry.getKey() == logLevel) {
                entry.getValue().forEach(sink -> sink.log(message));
            }
        }
    }
}
