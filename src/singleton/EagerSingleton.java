package singleton;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton(); // created at class loading

    private EagerSingleton() { } // private constructor

    public static EagerSingleton getInstance() {
        return instance;
    }
}

