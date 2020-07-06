public class StaticApp {
    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        welcome.call();
        Welcome.call();
        Welcome welcome1 = null;
        welcome1.call();
    }

    private static class Welcome {
        public static void call() {
            System.out.println("Static method of welcome class");
        }
    }
}
