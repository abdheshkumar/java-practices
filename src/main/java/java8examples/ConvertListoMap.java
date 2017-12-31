package java8examples;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abdhesh on 22/07/17.
 */
public class ConvertListoMap {
    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        // key = id, value - websites
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getName));

        System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);

        list.add(new Hosting(6, "linode.com", 100000)); // new line

        // key = name, value - websites , but the key 'linode' is duplicated!?
        /*Map<String, Long> result4 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));*/
        Map<String, Long> result5 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );

        System.out.println("Result 5 : " + result5);

        Map<String, Long> result6 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> newValue
                )
        );

        System.out.println("Result 6 : " + result6);

        LinkedHashMap<String, Long> result7 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 7 : " + result7);
    }
}

class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }
//getters, setters and toString()
}