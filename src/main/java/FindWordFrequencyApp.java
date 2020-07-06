import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//How will you find Word Frequency in a collection of words
public class FindWordFrequencyApp {
    public static void main(String[] args) {
        //String to array
        String[] strings = "hello ds".split(" "); //split("[ ]");
        System.out.println(Arrays.toString(strings));
        //Array of string to stream
        Stream<String> strings1 = Stream.of(strings);
        List<String> collect1 = strings1.collect(Collectors.toList());
        System.out.println(collect1);
        //Array of string to stream
        List<String> collect2 = Arrays.stream(strings).collect(Collectors.toList());
        System.out.println(collect2);
        List<String> stringList = Arrays.asList("a", "b", "a");
        ConcurrentMap<String, Integer> collect = stringList.stream()
                .collect(
                        Collectors.toConcurrentMap(Function.identity(), w -> 1, Integer::sum)
                );
        System.out.println(collect);
    }
}
