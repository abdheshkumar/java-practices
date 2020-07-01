package patterns;

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        System.out.println(logger);
        System.out.println(Logger.getLogger());
        System.out.println(logger.hashCode());
    }
}

class Logger {
    private static Logger logger = null;

    private Logger() {

    }

    static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}

class Emp{

}