package enums;

public enum LogLevel {
    INFO(3),
    ERROR(2),
    DEBUG(1);

    public int id;

    LogLevel(int id) {
        this.id = id;
    }
}
