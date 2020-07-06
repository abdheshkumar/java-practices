package collection;


import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

public class ComparatorApp {
    public static void main(String[] args) {
        Person[] person = {new ImplPerson(), new ImplPerson()};
        Arrays.sort(person);
        Arrays.sort(person, comparing(Person::getName));
        //Sort by name and then name
        Arrays.sort(person, comparing(Person::getName).thenComparing(Person::getId));
        Arrays.sort(person, comparing(Person::getName, Comparator.comparingInt(String::length)));
        Arrays.sort(person, Comparator.comparingInt(p -> p.getName().length()));
        Arrays.sort(person, comparing(Person::getName, nullsFirst(naturalOrder())));
        //Sort by ID then Name
        Arrays.sort(person, (person1, person2) -> {
            if (person1.getId() == person2.getId()) { //sort by name
                return person1.getName().compareToIgnoreCase(person2.getName());
            } else return Long.compare(person1.getId(), person2.getId());
        });
    }
}
