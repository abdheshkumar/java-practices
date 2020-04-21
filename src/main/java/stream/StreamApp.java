package stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

//https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
public class StreamApp {
    public static void main(String[] args) {
        Stream<String> st = Stream.<String>builder().add("a").add("b").add("c").build(); //Stream is a single use sequence
        boolean result = st.anyMatch(f -> f.startsWith("c")); //Scala's find function
        System.out.println(result);
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("A", "B", "C"); //It just like Scala's function

        boolean allTrue = streamSupplier.get().allMatch(f -> f.length() == 1); //Scala's forAll
        System.out.println(allTrue);
        Optional<String> findAny = streamSupplier.get().findAny();
        System.out.println(findAny.get());
        Optional<String> findFirst = streamSupplier.get().findFirst();
        System.out.println(findFirst.get());

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));

        System.out.println("listOfIntegers:");
        listOfIntegers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("listOfIntegers sorted in reverse order:");
        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);
        listOfIntegers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Parallel stream");
        listOfIntegers
                .parallelStream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("Another parallel stream:");
        listOfIntegers
                .parallelStream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");

        System.out.println("With forEachOrdered:");
        listOfIntegers
                .parallelStream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println("");
    }
}
