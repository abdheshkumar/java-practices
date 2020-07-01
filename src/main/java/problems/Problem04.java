package problems;

//Checking whether a string contains only digits
public class Problem04 {
    public static boolean containsOnlyDigits(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }
}
