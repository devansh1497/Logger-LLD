public class ConsoleLogger implements Sink {

    @Override
    public void log(String message) {
        System.out.println("Console logged: "+message);
    }
}
