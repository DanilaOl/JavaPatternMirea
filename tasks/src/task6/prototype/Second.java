package task6.prototype;

public class Second implements Copyable{
    private String text = "SecondText";

    public Second() {}

    public Second(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public Object copy() {
        return new Second(text);
    }
}
