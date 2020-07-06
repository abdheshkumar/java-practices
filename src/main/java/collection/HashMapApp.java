package collection;

import java.util.HashMap;
import java.util.Objects;

//If you don't override hashCode() and equals() then it will be considered as Identity HashMap
//It means keys are equal if their hasCode's are equal.
public class HashMapApp {
    public static void main(String[] args) {
        HashMap<Key, Value> map = new HashMap<>();
        map.put(new Key("a", "1"), new Value("1"));
        map.put(new Key("b", "2"), new Value("2"));
        map.put(new Key("c", "3"), new Value("3"));
        map.put(new Key("a", "1"), new Value("1"));
        System.out.println(map);
    }

    private static class Value {
        final private String value;

        public Value(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private static class Key {
        final private String key;
        final private String v;

        public Key(String key, String v) {
            this.key = key;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return Objects.equals(key, key1.key) &&
                    Objects.equals(v, key1.v);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, v);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "key='" + key + '\'' +
                    ", v='" + v + '\'' +
                    '}';
        }
    }
}
