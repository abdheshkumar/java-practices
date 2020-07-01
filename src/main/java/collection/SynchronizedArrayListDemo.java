package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedArrayListDemo {
    public static void main(String args[]) {
        // An ArrayList which is not synchronize
        List<String> listOfSymbols = new ArrayList<String>();

        listOfSymbols.add("RELIANCE");
        listOfSymbols.add("TATA");
        listOfSymbols.add("TECHMAH");
        listOfSymbols.add("HDFC");
        listOfSymbols.add("ICICI");

        // Synchronizing ArrayList in Java
        listOfSymbols = Collections.synchronizedList(listOfSymbols);

        // While Iterating over synchronized list, you must synchronize
        // on it to avoid non-deterministic behavior

        synchronized (listOfSymbols) {
            Iterator<String> myIterator = listOfSymbols.iterator();

            while (myIterator.hasNext()) {
                System.out.println(myIterator.next());
            }
        }
    }
}
