package task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Human> myList = new ArrayList<>();
        myList.add(new Human(22, "Danila", "Olyanin",
                LocalDate.of(2002, 1, 10), 80)
        );
        myList.add(new Human(21, "Vasya", "Pupkin",
                LocalDate.of(2000, 1, 1), 70)
        );
        myList.add(new Human(23, "Asdf", "Fdsa",
                LocalDate.of(2003, 10, 10), 90)
        );
        myList.add(new Human(19, "Ivan", "Ivanov",
                LocalDate.of(1999, 12, 12), 93)
        );
        myList.add(new Human(35, "Misha", "Ivanov",
                LocalDate.of(2005, 6, 16), 73)
        );

        Stream<Human> stream1 = myList.stream();
        stream1.sorted(Comparator.comparingInt(Human::getWeight).reversed()).forEach(System.out::println);
        System.out.println("---");

        Stream<Human> stream2 = myList.stream();
        stream2.filter(human -> !human.getLastName().equals("Ivanov")).forEach(System.out::println);
        System.out.println("---");

        Stream<Human> stream3 = myList.stream();
        stream3.sorted(Comparator.comparingInt(Human::getAge)).forEach(System.out::println);
        System.out.println("---");

        Stream<Human> stream4 = myList.stream();
        System.out.println(stream4.map(Human::getAge).reduce((a, b) -> a * b).get());
    }
}
