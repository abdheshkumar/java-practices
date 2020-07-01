package problems;

import java.util.Arrays;
import java.util.Comparator;

//Sorting an array of strings by length
public class Problem15 {

    public static void sortArrayByLength(String[] strs, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, (String s1, String s2)
                    -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs, (String s1, String s2)
                    -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
    }

    public static String[] sortArrayByLengthStream(String[] strs,
                                                   Sort direction) {
        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }
}
