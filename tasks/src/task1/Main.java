package task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"asdf", "danila", "qwerty"};
        StringArrayReverse reverser = new StringArrayReverse();
        System.out.println(Arrays.toString(reverser.apply(arr)));
    }
}