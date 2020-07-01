import java.util.BitSet;

public class BitSetExample {
    public static void main(String[] args) {
        BitSet b1 = new BitSet(4);
        b1.set(0,true);
        b1.set(1,true);
        b1.set(2,true);
        b1.set(3,true);
        b1.set(47777773,true);
        b1.set(47777773,false);

        BitSet b2 = new BitSet(4);
        b2.set(0,true);
        b2.set(1,true);
        b2.set(2,true);
        b2.set(3,true);
        System.out.println(b1);
        System.out.println(b2);
    }
}
