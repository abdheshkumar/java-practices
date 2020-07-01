package functionalinterface;

import java.util.*;
import java.util.function.*;

/**
 * Created by abdhesh on 23/07/17.
 * https://github.com/PacktPublishing/Learning-Functional-Data-Structures-and-Algorithms
 */
public class FunctionalInterfacce {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);     // 100.0
        formula.sqrt(16);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);


        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        int [] aa = {2,0,3,9};
        Arrays.parallelPrefix(aa, (left, right) -> left + right); //[2, 2, 5, 14]
        System.out.println(Arrays.toString(aa));
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names, (a, b) -> a.compareTo(b));

        //Method and Constructor References
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        //Functional Interfaces
        System.out.println(cal(x -> x * 1.0, 1));

        //pass references of methods or constructors via the :: keyword
        Something something = new Something();
        //By Instance
        Converter<String, String> converter1 = something::startsWith;

        String converted1 = converter1.convert("Java");
        System.out.println(converted1);
//how the :: keyword works for constructors
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        //Predicates
        /**
         * Predicates
         Predicates are boolean-valued functions of one argument.
         The interface contains various default methods for composing predicates
         to complex logical terms (and, or, negate)
         */
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        /**
         * Functions
         Functions accept one argument and produce a result.
         Default methods can be used to chain multiple functions together (compose, andThen).
         */
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");     // "123"
        /**
         * Suppliers
         Suppliers produce a result of a given generic type.
         Unlike Functions, Suppliers don't accept arguments.
         */
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person

        /**
         * Consumers
         Consumers represents operations to be performed on a single input argument.
         */
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        /**
         * Comparators
         Comparators are well known from older versions of Java.
         Java 8 adds various default methods to the interface.
         */
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0

        /**
         * Optionals
         Optionals are not functional interfaces,
         instead it's a nifty utility to prevent NullPointerException
         */
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }


    public static double cal(Formula f, int a) {
        return f.calculate(a);
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

@FunctionalInterface
interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

/**
 * To ensure that your interface meet the requirements, you should add the @FunctionalInterface annotation.
 * The compiler is aware of this annotation and throws a compiler error as soon as you try to add a second abstract method declaration to the interface.
 * Keep in mind that the code is also valid if the @FunctionalInterface annotation would be omitted.
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
