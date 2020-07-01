package problems;

//Counting the occurrences of a certain character
public class Problem06 {
    public static long countOccurrencesOfACertainCharacter(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

}
