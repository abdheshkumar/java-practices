package collection;

public class SwapTwoNumber {

    static void solution1(int a, int b) {
        System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

        //swapping value of two numbers without using temp variable
        a = a + b; //now a is 30 and b is 20
        b = a - b; //now a is 30 but b is 10 (original value of a)
        a = a - b; //now a is 20 and b is 10, numbers are swapped

        System.out.println("value of a and b after swapping, a: " + a + " b: " + b);
    }

    static void solution2(int a, int b) {
        System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

        //swapping value of two numbers without using temp variable and XOR bitwise operator
        a = a ^ b; //now a is 6 and b is 4
        b = a ^ b; //now a is 6 but b is 2 (original value of a)
        a = a ^ b; //now a is 4 and b is 2, numbers are swapped

        System.out.println("value of a and b after swapping using XOR bitwise operation, a: " + a + " b: " + b);
    }

    static void solution3(int a, int b) {
        System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

        //swapping value of two numbers without using temp variable using multiplication and division
        a = a * b; //now a is 18 and b is 3
        b = a / b; //now a is 18 but b is 6 (original value of a)
        a = a / b; //now a is 3 and b is 6, numbers are swapped

        System.out.println("value of a and b after swapping using multiplication and division, a: " + a + " b: " + b);
    }

    public static void main(String[] args) {
        solution1(6, 3);
        System.out.println("--------------------------");
        solution2(6, 3);
        System.out.println("--------------------------");
        solution3(6, 3);
        System.out.println(solution5("Hello"));
    }

   static String solution5(String s) {
        try{
            System.out.println("Try block");
            return s + "Tr";
        }finally {
            System.out.println("Finally..");
            //return s + "My";
        }
    }


}
