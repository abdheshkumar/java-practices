public class AbApp {
    public static void main(String[] args) {
        new B();
    }
}

class A {

    public A() {
        greeting();
        prints();
    }

    void greeting() {
        System.out.println("Greeting from A");
    }


    static void prints() {
        System.out.println("Static from A");
    }
}

class B extends A {
    public B() {
        //It will by default call A's constructor which calling greeting and prints methods
        greeting();
        prints();
    }

    void greeting() {
        System.out.println("Greeting from B");
    }

    //We can not override static method
    static void prints() {
        System.out.println("Static from B");
    }
}