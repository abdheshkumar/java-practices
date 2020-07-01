package collection;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionApp {
    public static void testMap(Map<String, String> map) {
        System.out.println(map);
        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
        //wordLengh.remove("1");
        while (itr.hasNext()) {
            Map.Entry<String, String> current = itr.next();
            /*Map.Entry current1 = itr.next(); //
            current1.getKey();   //return Object
            current1.getValue(); //return Object*/

            if (current.getKey().equals("1")) {
                map.remove("1");
                //itr.remove(); // this will remove the current entry.
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        // step 1 - create a concurrent hashmap (optional)
        ConcurrentHashMap<String, String> wordLength = new ConcurrentHashMap<>();
        wordLength.put("1", "1");
        wordLength.put("2", "2");
        wordLength.put("3", "3");
        wordLength.put("1", "1");
        wordLength.mappingCount(); // Return long, ConcurrentHashMap may contain more mappings than can be represented as an int
        wordLength.size(); //Return int
        //wordLengh.put(null,null); //Key and value both should be not null
        testMap(wordLength);
        // step 2 - create a set from map by using newKeySet() method
        // provide size to prevent resizing and better performance
        Set<String> words = ConcurrentHashMap.newKeySet(wordLength.size());

        // step 3 - you can add elements into set
        words.add("Java");
        words.add("JavaScript");

        // step 4 - you can remove elements from set
        words.remove("JavaScript");

        // STEP 5 - YOU CAN ALSO PASS THIS SET TO ANY METHOD EXPECTING SET
        System.out.println(words);
        LinkedHashMap<String, String> objectObjectLinkedHashMap = new LinkedHashMap<>();
        objectObjectLinkedHashMap.put("1", "1");
        objectObjectLinkedHashMap.put("2", "2");
        objectObjectLinkedHashMap.put("3", "3");
        objectObjectLinkedHashMap.put("1", "1");
        objectObjectLinkedHashMap.put(null, null); //Only one null key is allowed
        objectObjectLinkedHashMap.put(null, null);
        objectObjectLinkedHashMap.put("4", null);
        objectObjectLinkedHashMap.put("5", null); //Allowed many null values
        //testMap(objectObjectLinkedHashMap);

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
        hashMap.put("1", "1");
        hashMap.put(null, null); //Only one null key is allowed
        hashMap.put(null, null);
        hashMap.put("4", null);
        hashMap.put("5", null); //Allowed many null values

        System.out.println(hashMap);
        //testMap(hashMap);

        System.out.println(objectObjectLinkedHashMap);
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("1", "1");
        stringStringHashtable.put("2", "2");
        stringStringHashtable.put("3", "3");
        stringStringHashtable.put("1", "1");
        //stringStringHashtable.put(null,null); //Key and value both should be not null
        testMap(stringStringHashtable);
    }
}
