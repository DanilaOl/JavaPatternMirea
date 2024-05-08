package task7.decorator;

public class ReverseText extends Wrapper{
    public ReverseText() {}

    public ReverseText(Wrapper preprocessor) {
        super(preprocessor);
    }

    @Override
    public String editText(String text) {
        String preprocessedText = super.editText(text);
        return new StringBuilder(preprocessedText).reverse().toString();
    }
}
