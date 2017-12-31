package java8examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class ConvertMaptoList {
    public static void main(String arg[]) {
        Map<String, String> map = new HashMap<>();

// Convert all Map keys to a List
        List<String> result = new ArrayList(map.keySet());

// Convert all Map values to a List
        List<String> result2 = new ArrayList(map.values());

// Java 8, Convert all Map keys to a List
        List<String> result3 = map.keySet().stream()
                .collect(Collectors.toList());

// Java 8, Convert all Map values  to a List
        List<String> result4 = map.values().stream()
                .collect(Collectors.toList());

// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc.
        List<String> result5 = map.values().stream()
                .filter(x -> !"apple".equalsIgnoreCase(x))
                .collect(Collectors.toList());

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(10, "apple");
        map1.put(20, "orange");
        map1.put(30, "banana");
        map1.put(40, "watermelon");
        map1.put(50, "dragonfruit");

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map1.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());

        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);
    }
}
