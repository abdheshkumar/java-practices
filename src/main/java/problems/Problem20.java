package problems;

import java.util.Collections;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

//Concatenating the same string n times
public class Problem20 {
    public static void main(String[] args) {
        String result = String.format("%0" + 5 + "d", 0)
                .replace("0", "h");

        System.out.println(result);
        String text = "\n \n\n hello \t \n \r";
        String trimmed = text.trim();
        System.out.println(text);
        System.out.println(trimmed);

    }
    public static String concatRepeat(String str, int n) {
        //String result = String.join("", Collections.nCopies(n, str));
       /* String result = Stream.generate(() -> str)
                .limit(n)
                .collect(joining());*/
        StringBuilder sb = new StringBuilder(str.length() * n);
        for (int i = 1; i <= n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
