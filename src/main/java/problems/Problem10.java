package problems;

import java.util.stream.IntStream;
//Generating all permutations
public class Problem10 {
    private static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                            str.substring(i + 1, n) + str.substring(0, i)));
        }
    }
}
