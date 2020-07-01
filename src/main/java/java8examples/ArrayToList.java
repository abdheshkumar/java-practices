package java8examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abdhesh on 22/07/17.
 */
public class ArrayToList {
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
        List<int[]> ints = Arrays.asList(number); //Arrays.asList will have a fixed size;The original array and the list share the same references to the objects

        System.out.println(ints);
        List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        List<String> list1 = Arrays.asList(new String[]{"foo", "bar"});
        //list1.add("Tets"); //It will through error
        System.out.println(list1);
        ArrayList<String> arrayList = new ArrayList() {{
            add("Mr.Green");
            add("Mr.Yellow");
            add("Mr.Red");
        }};

        List<String> list2 = Stream.of("foo", "bar")
                .collect(Collectors.toList());

/*//Java 9
        List<String> list = List.of("foo", "bar", "baz");
        Set<String> set = Set.of("foo", "bar", "baz");
*/
    }
}
