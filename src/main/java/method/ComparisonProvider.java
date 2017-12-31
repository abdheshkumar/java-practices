package method;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

/**
 * Created by abdhesh on 15/07/17.
 */
class ComparisonProvider {
    public void show() {
        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);

    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
}