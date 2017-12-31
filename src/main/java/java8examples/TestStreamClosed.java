package java8examples;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by abdhesh on 22/07/17.
 */
public class TestStreamClosed {
    public static void main(String[] args) {

        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);

        // loop a stream
        stream.forEach(x -> System.out.println(x));

        // reuse it to filter again! throws IllegalStateException
        //long count = stream.filter(x -> "b".equals(x)).count();
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);

    }
}
