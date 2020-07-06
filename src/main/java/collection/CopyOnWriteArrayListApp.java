package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListApp {
    public static void main(String[] args) {
        //ArrayList<String> strings = new ArrayList<>();
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        strings.add("1");
        strings.add("2");
        System.out.println(strings);
        addEl(strings);
        System.out.println(strings);
    }

    static void addEl(Collection<String> stringCollection) {
        for (String s : stringCollection) {
            if (s.equals("1")) stringCollection.add("3");
        }
    }
}
