package collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

//concurrent version for TreeSet
public class ConcurrentSkipListSetApp {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add("1");
        concurrentSkipListSet.add("2");
        concurrentSkipListSet.add("1");
        //concurrentSkipListSet.add(null);
        System.out.println(concurrentSkipListSet);
        for (Iterator<String> it = concurrentSkipListSet.iterator(); it.hasNext(); ) {
            String s = it.next();
            if (s.equals("1")) concurrentSkipListSet.remove(s);
        }
        System.out.println(concurrentSkipListSet);
    }
}
