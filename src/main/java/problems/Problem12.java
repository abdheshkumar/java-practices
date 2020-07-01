package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Removing duplicate characters
public class Problem12 {

    public static String removeDuplicates(String str) {
        char[] chArray = str.toCharArray(); // or, use charAt(i)
        StringBuilder sb = new StringBuilder();
        for (char ch : chArray) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesUsingSet(String str) {
        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();
        for (char c: chArray) {
            if (chHashSet.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesStream(String str) {
        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }
}
