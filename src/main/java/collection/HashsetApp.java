package collection;

import java.util.HashSet;
import java.util.Iterator;

/*
When you create an object of HashSet in Java, it internally create instance of backup Map with default initial capacity 16 and default load factor 0.75
HashSet internally implemented using HashMap
 */
public class HashsetApp {
    public static void main(String[] args) {
        HashSet<String> supportedCurrencies = new HashSet<>();

        // adding object into HashSet, this will be translated to put() calls
        supportedCurrencies.add("USD");
        supportedCurrencies.add("EUR");
        supportedCurrencies.add("JPY");
        supportedCurrencies.add("GBP");
        supportedCurrencies.add("INR");
        supportedCurrencies.add("CAD");

        // retrieving object from HashSet
        Iterator<String> itr = supportedCurrencies.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }
    }
}
