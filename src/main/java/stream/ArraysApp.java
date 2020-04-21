package stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntConsumer;

public class ArraysApp {
    public static void main(String[] args) {
        String[] intro = new String[]{"once", "upon", "a", "time"};
        String[] copy = Arrays.copyOf(intro, 10);
        System.out.println(Arrays.toString(copy));
        String[] stutter = new String[3];
        Arrays.fill(stutter, "once");
        System.out.println(Arrays.toString(stutter));
        boolean result = Arrays.equals(new String[]{"once", "upon", "a", "time"}, intro);
        System.out.println(result);

        String[] sorted = Arrays.copyOf(intro, 4);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        Optional<String> r1 = Arrays.stream(intro)
                .reduce((v1, v2) -> v1 + v2);
        System.out.println(r1.get());
        String r2 = Arrays.stream(intro).reduce("Hello", (v1, v2) -> v1 + v2);
        System.out.println(r2);
        int r3 = Arrays.stream(intro).reduce(0, (v1, v2) -> {
            System.out.println("V1=" + v1 + "V2=" + v2);
            return v1 + v2.length();
        }, (v1, v2) -> {
            System.out.println("V1:" + v1);
            return v1 + v2;
        });
        System.out.println(r3);
    }
}

class Averager implements IntConsumer {
    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total) / count : 0;
    }

    public void accept(int i) {
        total += i;
        count++;
    }

    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}