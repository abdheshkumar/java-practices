package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Counting duplicate characters
public class Problem01 {

    public Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> v == null ? 1 : v++);
        }
        return result;
    }

    public Map<Character, Long> countDuplicateCharactersStream(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                //.collect(Collectors.groupingBy(c->c, Collectors.counting()));
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
