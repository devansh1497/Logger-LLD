public class FileLogger implements Sink {
    @Override
    public void log(String message) {
        System.out.println("File logged: "+message);
    }
}
