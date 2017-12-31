package java8examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by abdhesh on 22/07/17.
 */
public class Java8flatMap {
    /**
     * Stream<String[]>		-> flatMap ->	Stream<String>
     * Stream<Set<String>>	-> flatMap ->	Stream<String>
     * Stream<List<String>>	-> flatMap ->	Stream<String>
     * Stream<List<Object>>	-> flatMap ->	Stream<Object>
     */

    public static void main(String[] args) {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream1 = temp.filter(x -> "a".equals(x.toString()));

        stream1.forEach(System.out::println);
        /*Stream<String>, GOOD!*/
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);

		Stream<String> stream2 = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> "a".equals(x.toString()));

        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));


    }

}

class Student {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
    //getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    public void show() {
        new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        final String[] array = { "hello", "world" };
    }
}