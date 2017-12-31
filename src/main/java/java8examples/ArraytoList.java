package java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class ArraytoList {
    public static void main(String[] args) {

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // IntStream.of or Arrays.stream, same output
        //List<Integer> list = IntStream.of(number).boxed().collect(Collectors.toList());
/**
 * You can’t use the popular Arrays.asList to convert it directly, because boxing issue.
 int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 // No, the return type is not what we want
 List<int[]> ints = Arrays.asList(number);
 */
        List<int[]> ints = Arrays.asList(number);
        System.out.println(ints);
        List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);

    }
}
