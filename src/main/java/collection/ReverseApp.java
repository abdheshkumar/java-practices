package collection;

public class ReverseApp {
    public static void main(String[] args) {
        //1
        String word = "HelloWorld";
        String reverse = new StringBuffer(word).reverse().toString();
        System.out.printf(" original String : %s ,reversed String %s  %n", word, reverse);
        //2
        word = "Band";
        reverse = reverse(word);
        System.out.printf(" original String : %s ,reversed String %s %n", word, reverse);
    }

    public static String reverse(String source) {
        if (source == null || source.isEmpty()) return source;
        String reverse = "";
        for (int i = source.length() - 1; i >= 0; i--) {
            reverse = reverse + source.charAt(i);
        }
        return reverse;
    }
}
