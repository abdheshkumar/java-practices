package collection;


import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static javafx.scene.input.DataFormat.URL;

public class FunctionalInterfaceApp {
    public static void main(String[] args) {
        Greator<Account> ac = (arg1, args2) -> arg1.getBalance() > args2.getBalance() ? arg1 : args2;
        Person person = () -> 12;
        System.out.println(person.getName());
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();
//Stateful stream
        Stream<String> uniqueWords
                = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        List<String> wordList = Arrays.asList("Hello");
        Supplier<Stream<String>> words = () -> wordList.stream();
        Stream<String> lowercaseWords = words.get().map(String::toLowerCase);
        Stream<Character> firstChars = words.get().map(s -> s.charAt(0));
        Stream<String> longWords = words.get().filter(w -> w.length() > 12);
        Stream<String> longestFirst =
                words.get().sorted(Comparator.comparing(String::length).reversed());
        Stream<Stream<Character>> result = words.get().map(w -> characterStream(w));
        Stream<Character> letters = words.get().flatMap(w -> characterStream(w));
        //Extracting Substreams and Combining Streams
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);

        String contents = "";
        //words = Stream.of(contents.split("[\\P{L}]+")).skip(1);
        Stream<Character> combined = Stream.concat(
                characterStream("Hello"), characterStream("World"));
        Stream<String> longestFirst1 =
                words.get().sorted(Comparator.comparing(String::length).reversed());
        Optional<String> largest = words.get().max(String::compareToIgnoreCase);
        String[] result1 = words.get().toArray(String[]::new);
        HashSet<String> result2 = words.get().collect(HashSet::new, HashSet::add, HashSet::addAll);
        Set<String> result3 = words.get().collect(Collectors.toSet());
        TreeSet<String> result4 = words.get().collect(Collectors.toCollection(TreeSet::new));
        String result5 = words.get().collect(Collectors.joining());
        Supplier<Stream<Locale>> locales = () -> Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.get().collect(
                Collectors.toMap(
                        l -> l.getDisplayLanguage(),
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));

        Map<String, Set<String>> countryLanguageSets = locales.get().collect(
                Collectors.toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> { // Union of a and b
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }));
        Map<String, List<Locale>> countryToLocales = locales.get().collect(
                Collectors.groupingBy(Locale::getCountry));

        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.get().collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        //The groupingBy method yields a map whose values are lists.
        Map<String, Set<Locale>> countryToLocaleSet = locales.get().collect(
                Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        Map<String, Long> countryToLocaleCounts = locales.get().collect(
                groupingBy(Locale::getCountry, counting()));

        Map<String, Set<String>> countryToLanguages = locales.get().collect(
                groupingBy(l -> l.getDisplayCountry(),
                        mapping(l -> l.getDisplayLanguage(),
                                toSet())));
        Map<Boolean, List<Locale>> englishAndOtherLocalesEn = locales.get().collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> localeList = englishAndOtherLocalesEn.get(true);

        ConcurrentMap<Boolean, List<Locale>> booleanListConcurrentMap = locales.get().collect(
                groupingByConcurrent(l -> l.getLanguage().equals("en")));
        Map<String, Long> stringLongMap = locales.get().collect(
                groupingBy(Locale::getCountry, counting()));

        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        Optional<Integer> sum = values.stream().reduce((x, y) -> x + y);
        values.stream().reduce(Integer::sum);
        System.out.println(sum);

        Integer sumInt = values.stream().reduce(0, (x, y) -> x + y);
        //parallel stream
        int resultInt = words.get().reduce(0,
                (total, word) -> total + word.length(),
                (total1, total2) -> total1 + total2);
        IntStream stream = IntStream.of(1, 1, 2, 3, 5);
        IntStream zeroToNinetyNine = IntStream.range(0, 100); // Upper bound is excluded
        IntStream zeroToHundred = IntStream.rangeClosed(0, 100); // Upper bound is included

        Map<Integer, Long> shortWordCounts
                = words.get().parallel()
                .filter(s -> s.length() < 12)
                .collect(groupingBy(
                        String::length,
                        counting()));

        Stream<String> song = Stream.of("gently", "down", "the", "stream");

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }
}

@FunctionalInterface
interface Person {
    long getId();

    default String getName() {
        return "John Q. Public" + getId();
    }
}

class ImplPerson implements Person {
    @Override
    public long getId() {
        return (int) Math.random();
    }
}

@FunctionalInterface
interface Greator<T> {
    public T greater(T arg1, T args2);
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + "}";
    }
}