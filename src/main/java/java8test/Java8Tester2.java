package java8test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdhesh on 15/07/17.
 */
public class Java8Tester2 {
    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }
}
