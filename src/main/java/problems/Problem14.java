package problems;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Finding the character with the most appearances
public class Problem14 {
    public static AbstractMap.SimpleImmutableEntry<Character, Long> maxOccurenceCharacter(String str) {
        return str.chars()
                .filter(c -> Character.isWhitespace(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.<Character, Long>comparingByValue())
                .map(p -> new AbstractMap.SimpleImmutableEntry<>(p.getKey(), p.getValue()))
                .orElse(new AbstractMap.SimpleImmutableEntry<>(Character.MIN_VALUE, -1L));
    }
}
