package task1;


import java.util.function.Function;

public class StringArrayReverse implements Function<String[], String[]> {

    @Override
    public String[] apply(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new StringBuilder(strings[i]).reverse().toString();
        }

        return strings;
    }
}