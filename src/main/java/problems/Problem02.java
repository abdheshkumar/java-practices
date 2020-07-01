package problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Finding the first non-repeated character
public class Problem02 {

    public char firstNonRepeatedCharacter(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();
        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public String firstNonRepeatedCharacterStream(String str) {
        Map<Integer, Long> chs = str.codePoints().mapToObj(c -> c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream().filter(e -> e.getValue() == 1L)
                .findFirst()
                //.map(e->e.getKey())
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
        return String.valueOf(Character.toChars(cp));
    }
}
