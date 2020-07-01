package problems;

public class SearchElementInSortedTwoDArray {
    static boolean search(int X[][], int x) {
        int n = X.length;
        int m = X[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (X[i][j] == x) return true;
            else if (X[i][j] > x) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int X[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(search(X, 29));
    }
}
