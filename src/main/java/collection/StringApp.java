package collection;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Map.*;

public class StringApp {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();//thread-safe
        StringBuilder stringBuilder = new StringBuilder();//not thread safe
        ArrayList<String> arrayList = new ArrayList<>();//not thread safe
        Vector<String> stringVector = new Vector<>();//thread safe
        HashMap<String, String> stringStringHashMap = new HashMap<>();//not thread safe and allow only one null keys and many null values
        for (Map.Entry<String, String> entry : stringStringHashMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        stringStringHashMap.forEach((key, value) -> System.out.println(key));
        stringStringHashMap.keySet().stream().forEach(System.out::println);

        Hashtable<String, String> stringStringHashtable = new Hashtable<>();//thread safe and doesn't allow nulls
        //TreeSet is implemented via a TreeMap, much like how HashSet is implemented using HashMap

        TreeSet<String> stringTreeSet = new TreeSet<>();//Not allow nulls, not thread safe
        TreeMap<String, String> stringTreeMap = new TreeMap<>();//Not allow nulls, not thread safe

        Set<Weekday> always = EnumSet.allOf(Weekday.class);
        System.out.println("Always " + always);
        Set<Weekday> never = EnumSet.noneOf(Weekday.class);
        System.out.println("Never " + never);
        Set<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        System.out.println("Workday " + workday);
        Set<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        System.out.println("MWF " + mwf);

        EnumMap<Weekday, String> personInCharge = new EnumMap<>(Weekday.class);
        personInCharge.put(Weekday.MONDAY, "Fred");

        /*
        Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. They are not thread-safe.
        They do not support concurrent access by multiple threads. Null elements are prohibited
         */
        System.out.println("**********Stack**ArrayDeque**Use push************");
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Peter");
        stack.push("Paul");
        stack.push("Mary");
        //stack.push(null);
        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println("**********Queue**ArrayDeque****Use add**********");
        ArrayDeque<String> queue = new ArrayDeque<>();
        //Deque<String> queue1 = new ArrayDeque<>();
        queue.add("Peter");
        queue.add("Paul");
        queue.add("Mary");
        queue.add("Mine");

        while (!queue.isEmpty())
            System.out.println( " pop: " + queue.pop());


        Comparator<Job> jobComparator = Comparator.comparingInt(job -> job.priority);
        PriorityQueue<Job> jobs = new PriorityQueue<>(jobComparator);
        jobs.add(new Job(4, "Collect garbage"));
        jobs.add(new Job(9, "Match braces"));
        jobs.add(new Job(1, "Fix memory leak"));
        while (jobs.size() > 0) {
            Job job = jobs.remove(); // The most urgent jobs are removed first
            System.out.println(job);
        }

        //Java 9
        /*
        List<String> names = List.of("Peter", "Paul", "Mary");
        Set<Integer> numbers = Set.of(2, 3, 5);
        Map<String, Integer> scores = Map.of("Peter", 2, "Paul", 3, "Mary", 5);
        Map<String, Integer> scores = ofEntries(
                entry("Peter", 2),
                entry("Paul", 3),
                entry("Mary", 5));
//These collection objects are unmodifiable. Any attempt to change their contents
//results in an UnsupportedOperationException
         */
        //If you want a mutable collection, you can pass the unmodifiable collection        to the constructor:
        //List<String> names = new ArrayList<>(List.of("Peter", "Paul", "Mary"));

        //There is also a static Arrays.asList method that is similar to
        //List.of . It returns a mutable list that is not resizable. That is, you can
        //call set but not add or remove on the list.
        //Optional
        Optional<String> optionalString = Optional.of("Hello");//Fail for null
        Optional<Object> empty = Optional.empty();
        Optional.ofNullable(null);
        String result = optionalString.orElse("");

        String elseGet = optionalString.orElseGet(() -> System.getProperty("myapp.default"));
        String s = optionalString.orElseThrow(IllegalStateException::new);

        //How to convert an array of String to arraylist?
        String[] words = {"ace", "boom", "crew", "dog", "eon"};
        List<String> strings = Arrays.asList(words);
        ArrayList<String> arrayList1 = new ArrayList(Arrays.asList(strings));
        Collections.reverse(arrayList1);
        System.out.println(arrayList1);

    }

    private static class Job implements Comparable<Job> {
        int priority;
        String name;

        Job(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "priority=" + priority +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Job o) {
            System.out.println("Com..");
            return Integer.compare(this.priority, o.priority);
        }
    }
}

enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}