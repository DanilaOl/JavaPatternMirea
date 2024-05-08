package task7.decorator;

public class TestApp {
    public TestApp() {
        String testString = "Danila";
        String string1 = new ReverseText().editText(testString);
        String string2 = new DoubleText().editText(testString);

        System.out.println(string1);
        System.out.println(string2);
    }
}
