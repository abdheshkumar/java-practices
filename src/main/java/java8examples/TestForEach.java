package java8examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abdhesh on 22/07/17.
 */
public class TestForEach {
    public static void main(String args[]) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
//Java7
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        //Java8
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        List<String> itemsList = new ArrayList<>();
        itemsList.add("A");
        itemsList.add("B");
        itemsList.add("C");
        itemsList.add("D");
        itemsList.add("E");
        itemsList.forEach(s -> System.out.println(s));

    }

}
