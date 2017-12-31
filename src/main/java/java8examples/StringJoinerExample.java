package java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class StringJoinerExample {
    public static void main(String arg[]) {
        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
        System.out.println("StringJoinerExample.main " + result);

        StringJoiner sj2 = new StringJoiner("/", "prefix-", "-suffix");
        sj2.add("2016");
        sj2.add("02");
        sj2.add("26");
        String result2 = sj2.toString(); //prefix-2016/02/26-suffix
        System.out.println(result2);

        String result3 = String.join("-", "2015", "10", "31");

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        //java, python, nodejs, ruby
        String result4 = String.join(", ", list);

        List<String> list1 = Arrays.asList("java", "python", "nodejs", "ruby");

//java | python | nodejs | ruby
        String result6 = list1.stream().collect(Collectors.joining(" | "));
        System.out.println(result6);
    }
}
