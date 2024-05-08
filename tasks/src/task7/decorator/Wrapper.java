package task7.decorator;

public abstract class Wrapper {
    private Wrapper preprocessor;

    public Wrapper() {}

    public Wrapper(Wrapper preprocessor) {
        this.preprocessor = preprocessor;
    }

    public String editText(String text) {
        if (!(preprocessor == null)) {
            text = preprocessor.editText(text);
        }

        return text;
    }
}
