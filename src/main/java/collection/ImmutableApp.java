package collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {
        LinkedList<String> words = new LinkedList<>();
        words.add("Hello");
        words.add("There");
        List<String> unmodifiableList = Collections.unmodifiableList(words);
        System.out.println(unmodifiableList);
        words.add("Cheating");
        //unmodifiableList.add("Cheating"); //java.lang.UnsupportedOperationException
        System.out.println(unmodifiableList); //isn’t really immutable
    }
}
