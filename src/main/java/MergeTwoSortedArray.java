import java.util.Arrays;
import java.util.stream.IntStream;

//Merge k sorted arrays
public class MergeTwoSortedArray {

    static void mergeSortedArray(int arr1[], int arr2[]) {
        int[] ints = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(ints));
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 5, 6};
        int arr2[] = {3, 4,7,8,10,34,56};
        mergeSortedArray(arr1, arr2);
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int result[] = new int[arr1Length + arr2Length];
        int i = 0, j = 0, k = 0;
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] < arr2[j]) result[k++] = arr1[i++];
            else result[k++] = arr2[j++];
        }

        if (i < arr1Length) while (i < arr1Length) {
            result[k++] = arr1[i++];
        }

        if (j < arr2Length) while (j < arr2Length) {
            result[k++] = arr2[j++];
        }

        System.out.println(Arrays.toString(result));
    }
}
