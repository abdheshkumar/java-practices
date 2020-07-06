package collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

//concurrent version for TreeMap
public class ConcurrentSkipListMapApp {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String,String> concurrentSkipListSet = new ConcurrentSkipListMap<>();
        concurrentSkipListSet.put("1","1");
        concurrentSkipListSet.put("2","2");
        concurrentSkipListSet.put("1","1");
        concurrentSkipListSet.put("4","4");
        concurrentSkipListSet.put("3","3");
        //concurrentSkipListSet.put(null,"3"); //Not allows nulls
        System.out.println(concurrentSkipListSet);
        /*for (Iterator<String> it = concurrentSkipListSet.; it.hasNext(); ) {
            String s = it.next();
            if (s.equals("1")) concurrentSkipListSet.remove(s);
        }
        System.out.println(concurrentSkipListSet);*/
    }
}
