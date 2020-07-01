package collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//removed duplicates from ArrayList
public class RemoveArrayListDuplicate {
    public static void main(String[] args) {
        // creating ArrayList with duplicate elements
        List<Integer> primes = new ArrayList<Integer>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(7);  //duplicate
        primes.add(11);
        System.out.println("list of prime numbers : " + primes);

        Set<Integer> primesWithoutDuplicates = new LinkedHashSet<Integer>(primes);

        // now let's clear the ArrayList so that we can copy all elements from LinkedHashSet
        primes.clear();

        // copying elements but without any duplicates
        primes.addAll(primesWithoutDuplicates);

        System.out.println("list of primes without duplicates : " + primes);
    }
}
