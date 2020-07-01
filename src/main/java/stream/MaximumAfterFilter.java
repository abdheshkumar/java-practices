package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumAfterFilter {

    static long test(String s1) {


        long result = Arrays.stream(s1.split("[!|.|?]"))
                .map(str -> Arrays.stream(str.split("[ ]+")).filter(f -> !f.isEmpty()).count())
                .max(Long::compare).orElse(0L);


        return result;
    }

    public static void main(String[] args) {
        String s = "we test coders. Give us a try?";

        String s1 = "Forget CVs..Save time . x x";


        System.out.println(test(s));
        System.out.println(test(s1));

        //Join Two Arrays
        String[] animals1 = new String[]{"Dog", "Cat"};
        String[] animals2 = new String[]{"Bird", "Cow"};
        String[] result = Stream.concat(Arrays.stream(animals1), Arrays.stream(animals2)).toArray(String[]::new);
        System.out.println(Arrays.toString(result));

        //Join Two Collections
        Collection<String> collection1 = Arrays.asList("Dog", "Cat");
        Collection<String> collection2 = Arrays.asList("Bird", "Cow");
        Collection<String> collectionResult = Stream.concat(collection1.stream(), collection2.stream()).collect(Collectors.toList());
        System.out.println(collectionResult);

        //Join Two Collections With Filter
        Collection<String> collection3 = Arrays.asList("Dog", "Cat");
        Collection<String> collection4 = Arrays.asList("Bird", "Cow");
        Collection<String> stringCollection = Stream.concat(collection3.stream(), collection4.stream()).filter(e -> e.length() == 3).collect(Collectors.toList());
        System.out.println(stringCollection);

    }


}
