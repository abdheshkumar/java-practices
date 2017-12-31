package java8examples;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class FilterMap {
    public static void main(String args[]) {
        HashMap<String, String> stringHashMap = new HashMap<>();
        String result = stringHashMap.entrySet().stream()
                .filter(map -> "something".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
//Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = integerStringHashMap.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
    }
}
