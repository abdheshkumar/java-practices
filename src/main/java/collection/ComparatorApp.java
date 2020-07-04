package collection;


import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

public class ComparatorApp {
    public static void main(String[] args) {
        Person[] person = {new ImplPerson(), new ImplPerson()};
        Arrays.sort(person);
        Arrays.sort(person, comparing(Person::getName));
        Arrays.sort(person, comparing(Person::getName).thenComparing(Person::getId));
        Arrays.sort(person, comparing(Person::getName, Comparator.comparingInt(String::length)));
        Arrays.sort(person, Comparator.comparingInt(p -> p.getName().length()));
        Arrays.sort(person, comparing(Person::getName, nullsFirst(naturalOrder())));
    }
}
