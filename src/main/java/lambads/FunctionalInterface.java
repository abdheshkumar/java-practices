package lambads;

import java.util.function.BinaryOperator;
import java.util.function.DoubleToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;

/**
 * Created by abdhesh on 22/07/17.
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x > 5;
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
        LongUnaryOperator doubleToIntFunction = x -> x + 1;
    }
}
