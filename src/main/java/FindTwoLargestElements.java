import java.util.function.BiPredicate;

//Find the smallest and second smallest elements in an array
public class FindTwoLargestElements {
    static void print2Largest(int arr[], BiPredicate<Integer, Integer> predicate, int defaultValue) {
        int first, second, arrSize = arr.length;
        /* There should be atleast two elements */
        if (arrSize < 2) {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = defaultValue;
        for (int i = 0; i < arrSize; i++) {
            /* If current element is largest than first then update both first and second */
            if (predicate.test(arr[i], first)) {
                second = first;
                first = arr[i];
            }
            /* If arr[i] is in between first and second then update second  */
            else if (predicate.test(arr[i], second) && arr[i] != first)
                second = arr[i];
        }
        if (second == defaultValue)
            System.out.println("There is no second element");
        else
            System.out.println("First: " + first + " and Second: " + second);
    }

    public static void main(String[] args) {
        int arr[] = {12, 13, 1, 10, 34, 100};
        print2Largest(arr, (a, v) -> a > v, Integer.MIN_VALUE);
        print2Largest(arr, (a, v) -> a < v, Integer.MAX_VALUE);
    }
}
