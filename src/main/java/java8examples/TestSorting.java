package java8examples;

/**
 * Created by abdhesh on 21/07/17.
 */

import java7examples.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        System.out.println("After Sort");

        //lambda here!
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
        listDevs.sort(Comparator.comparing(Developer::getAge));
        //Sort in reverse order
        listDevs.sort(Comparator.comparing(Developer::getName, (s1, s2) -> {
            return s2.compareTo(s1);
        }));

        listDevs.sort(Comparator.comparing(Developer::getName, (s1, s2) -> {
            return s2.compareTo(s1);
        }).reversed());

        listDevs.sort(Comparator.comparingInt(Developer::getAge));
        Comparator byName = Comparator.comparing(Developer::getName);
        listDevs.sort(Comparator.nullsFirst(byName));
        listDevs.sort(Comparator.nullsLast(byName));
        listDevs.sort(Comparator.comparing(Developer::getName).thenComparing(Developer::getAge));

        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer) -> System.out.println(developer));
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }

}