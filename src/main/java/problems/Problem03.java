package problems;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Reversing letters and words
public class Problem03 {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello world"));
    }
    private static final Pattern pattern = Pattern.compile(" +");
    public static String reverseWords(String str) {
       String result =  pattern.splitAsStream(str)
                .map(w-> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
       return result;
    }
}
