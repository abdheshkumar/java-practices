import java.util.*;

public class AnagramExample {
    public static void main(String[] args) {
        String s = "bedit card";
        String s1 = "bad credit";
        if (isAnagram(s, s1)) System.out.println("This is anagram");
        else System.out.println("This is not anagram");
        buildAnagram();
    }

    private static boolean isAnagram(String s, String s2) {
        char[] chars = s.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        if (Arrays.toString(chars).equals(Arrays.toString(chars1))) {
            return true;
        }
        return false;
    }

    private static void buildAnagram() {
        Map<String, List<String>> anagramMap = new HashMap<>();
        String[] inputWords = {"cat", "omt", "act", "dad", "tac", "dda", "add", "tom"};
        for (String word : inputWords) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(word);
        }
        System.out.println("Anagram::" + anagramMap);
    }
}
