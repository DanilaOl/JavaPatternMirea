package task7.decorator;

public class DoubleText extends Wrapper{
    public DoubleText() {}

    public DoubleText(Wrapper preprocessor) {
        super(preprocessor);
    }

    @Override
    public String editText(String text) {
        String preprocessedText = super.editText(text);
        return preprocessedText + preprocessedText;
    }
}
