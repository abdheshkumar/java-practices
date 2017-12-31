package java8examples;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abdhesh on 22/07/17.
 */
public class Arraycontains {
    public static void main(String[] args) {
        String[] alphabet = new String[]{"A", "B", "C"};

        // Convert String Array to List
        List<String> list = Arrays.asList(alphabet);

        if (list.contains("A")) {
            System.out.println("Hello A");
        }
// Convert to stream and test it// Java 8
        boolean result = Arrays.stream(alphabet).anyMatch("A"::equals);
        if (result) {
            System.out.println("Hello A");
        }
    }
}
