package problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Counting substring occurrences in a string
/*
problem that can
have at least two interpretations:
11 in 111 occurs 1 time
11 in 111 occurs 2 time
 */
public class Problem17 {
    public static void main(String[] args) {
        System.out.println(countStringInStringMultipleTimes("111", "11"));
    }

    public static int countStringInString(String string, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();
        while ((position = string.indexOf(toFind, position)) != -1) {
            position = position + n;
            System.out.println(position);
            count++;
        }
        return count;
    }

    public static int countStringInStringByRegex(String string, String toFind) {
        int result = string.split(Pattern.quote(toFind), -1).length - 1;
        return result < 0 ? 0 : result;
    }

    public static int countStringInStringMultipleTimes(String string, String toFind) {
        Pattern pattern = Pattern.compile(Pattern.quote(toFind));
        Matcher matcher = pattern.matcher(string);
        int position = 0;
        int count = 0;
        while (matcher.find(position)) {
            position = matcher.start() + 1;
            count++;
        }
        return count;
    }
}

