package collection;

import java.util.HashSet;
import java.util.TreeSet;
/*
HashSet is faster than TreeSet and should be preferred choice if sorting of elements is not required. TreeSet is internally backed by a Red-Black tree
HashSet allows null object but TreeSet doesn't allow null Object and throw NullPointerException, Why, because TreeSet uses compareTo() method to compare keys and compareTo() will throw java.lang.NullPointerException
HashSet is backed by HashMap while TreeSet is backed by TreeMap
 */
public class HashSetTreeSetApp {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Java");
        hashSet.add(null);

        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("C++");
        //treeSet.add(null); //treeset doesn't allow nulls
    }
}
