package collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        /*TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>();
        integerStringTreeMap.put(2, "2");
        integerStringTreeMap.put(1, "1");
        System.out.println(integerStringTreeMap);*/
        Comparator<Test> testComparator = (t1, t2) -> t1.name.compareToIgnoreCase(t2.name);
        TreeMap<Test, String> testStringTreeMap = new TreeMap<>(testComparator);
        testStringTreeMap.put(new Test("B"), "B");
        testStringTreeMap.put(new Test("A"), "A");
        System.out.println(testStringTreeMap);
    }

    private static class Test {
        final private String name;

        public Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
