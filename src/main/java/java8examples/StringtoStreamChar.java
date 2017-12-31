package java8examples;

/**
 * Created by abdhesh on 22/07/17.
 */
public class StringtoStreamChar {
    public static void main(String[] args) {

        String password = "password123";

        password.chars() //IntStream
                .mapToObj(x -> (char) x)//Stream<Character>
                .forEach(System.out::println);

    }
}
