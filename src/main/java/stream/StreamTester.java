package stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abdhesh on 15/07/17.
 */
public class StreamTester {
    public static void main(String[] arg) {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
