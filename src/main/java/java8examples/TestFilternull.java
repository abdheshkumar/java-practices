package java8examples;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abdhesh on 22/07/17.
 */
public class TestFilternull {
    public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

        //List<String> result = language.collect(Collectors.toList());

        List<String> result = language.filter(x -> x != null).collect(Collectors.toList());

        result.forEach(System.out::println);

        List<String> result1 = language.filter(Objects::nonNull).collect(Collectors.toList());
    }
}
