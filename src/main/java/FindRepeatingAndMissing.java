import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindRepeatingAndMissing {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};

        /*long N = (long) (arr.length + 1);
        long r = (N * (N + 1)) / 2;
        System.out.println(r);
        int sum = Arrays.stream(arr).sum();
        System.out.println(r - sum);*/
        Map<Integer, Boolean> numberMap = new HashMap<>();
        int max = arr.length;

        for (Integer i : arr) {
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            } else {
                System.out.println("Repeating = " + i);
            }
        }

        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                System.out.println("Missing = " + i);
            }
        }
    }
}
