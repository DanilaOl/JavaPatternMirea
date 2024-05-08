package task6.prototype;

public class First implements Copyable{
    private String message = "FirstMessage";

    public First() {}

    public First(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public Object copy() {
        return new First(message);
    }
}
