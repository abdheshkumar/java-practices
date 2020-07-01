package problems;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// Joining multiple strings with a delimiter
public class Problem09 {
    public static void main(String[] args) {
        System.out.println(String.join(String.valueOf(','), "sas", "asas", "sas"));
    }

    public static String joinByDelimiter(char delimiter, String... args) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);
        return result.toString();
    }

    public static String joinByDelimiterJoiner(char delimiter, String... args) {
        //String.join(String.valueOf(delimiter), args);
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
        for (String arg : args) {
            joiner.add(arg);
        }
        return joiner.toString();
    }

    public static String joinByDelimiterStream(char delimiter, String...args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }
}
