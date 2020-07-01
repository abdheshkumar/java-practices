package problems;

import java.util.*;
import java.util.stream.Collectors;

//Counting vowels and consonants
public class Problem05 {
    private static final Set<Character> allVowels
            = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static AbstractMap.SimpleEntry<Integer, Integer> countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
        AbstractMap.SimpleEntry<Integer, Integer> entry
                = new AbstractMap.SimpleEntry<>(vowels, consonants);
        /*
         *AbstractMap.SimpleImmutableEntry<Integer, Integer> entry
           = new AbstractMap.SimpleImmutableEntry<>(vowels, consonants); //Attempting to do so will result in an UnsupportedOperationException
         */
        return entry;
    }

    public static AbstractMap.SimpleEntry<Long, Long> countVowelsAndConsonantsStream(String str) {
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(Collectors.partitioningBy(c -> allVowels.contains(c), Collectors.counting()));
        AbstractMap.SimpleEntry<Long, Long> entry
                = new AbstractMap.SimpleEntry<>(result.get(true), result.get(false));
        return entry;
    }
}
