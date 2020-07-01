package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 15/07/17.
 * https://github.com/winterbe/java8-tutorial
 * https://stackoverflow.com/questions/20001427/double-colon-operator-in-java-8
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * https://winterbe.com/posts/2015/03/25/java8-examples-string-number-math-files/
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

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        String.join(":", "foobar", "foo", "bar");

        "foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());
    }
}
