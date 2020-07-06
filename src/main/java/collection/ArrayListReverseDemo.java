package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListReverseDemo {
    public static void main(String args[]) {

        ArrayList<String> listOfInts = new ArrayList<>();
        listOfInts.add("1");
        listOfInts.add("2");
        listOfInts.add("3");
        listOfInts.add("4");
        listOfInts.add("5");
        listOfInts.add("6");
        listOfInts.add("7");
        listOfInts.add("8");
        listOfInts.add("9");
        listOfInts.add("10");
        listOfInts.add("11");

        System.out.println("Before Reversing : " + listOfInts);
        System.out.println("Capacity: "+ listOfInts.size());
        Collections.reverse(listOfInts);
        System.out.println("After Reversing : " + listOfInts);


        List<String> listOfString = Arrays.asList("London", "Tokyo", "NewYork");
        //listOfString.add("Tes");//Exception in thread "main" java.lang.UnsupportedOperationException
        Collections.sort(listOfString, Collections.reverseOrder());
        System.out.println(listOfString); //[Tokyo, NewYork, London]
    }
}
