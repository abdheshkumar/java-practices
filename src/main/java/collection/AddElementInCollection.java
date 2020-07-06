package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ListIterator;

public class AddElementInCollection {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
        //addInCollection(arrayList);
        addInCollectionAnotherSolution(arrayList);
        System.out.println(arrayList);
    }

    static void addInCollection(Collection<Integer> collection) {
        ListIterator<Integer> integerListIterator = ((ArrayList<Integer>) collection).listIterator();
        for (; integerListIterator.hasNext(); ) {
            Integer integer = integerListIterator.next();
            if (integer == 4) integerListIterator.add(5);
        }
        /*for (Integer i : collection) {
            collection.add(5);//java.util.ConcurrentModificationException
        }*/
    }

    static void addInCollectionAnotherSolution(Collection<Integer> collection) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer i : collection) {
            if (i == 4) integers.add(5);
        }
        collection.addAll(integers); //Add temp collection into original collection
    }
}
