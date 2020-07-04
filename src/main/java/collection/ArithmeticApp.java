package collection;

public class ArithmeticApp {
    public static void main(String[] args) {
        Double d1 = 100 / 0.0; //Infinity
        System.out.println(d1);
        Double d2 = 0.0 / 0.0; //NaN
        System.out.println(d2);
        //int i = 100 / 0; //java.lang.ArithmeticException: / by zero
        //System.out.println(i);
    }
}
