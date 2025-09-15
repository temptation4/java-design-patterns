package singleton;

import java.io.*;

// A robust Singleton class
public class RobustSingleton implements Serializable, Cloneable {

    // 1. Private static volatile instance
    private static volatile RobustSingleton instance;

    // 2. Private constructor (blocks direct instantiation)
    private RobustSingleton() {
        // Prevent Singleton from being broken via Reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    // 3. Public static method with Double-Checked Locking
    public static RobustSingleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (RobustSingleton.class) {
                if (instance == null) { // Second check (with lock)
                    instance = new RobustSingleton();
                }
            }
        }
        return instance;
    }

    // 4. Prevent Cloning from breaking Singleton
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton - Cloning not allowed");
        // OR return instance; if you prefer same object instead of exception
    }

    // 5. Prevent Serialization from breaking Singleton
    // This ensures deserialization returns the same instance
    protected Object readResolve() {
        return getInstance();
    }

    // A simple demo method
    public void showMessage() {
        System.out.println("Hello from Robust Singleton!");
    }

    // 6. Test the Singleton
    public static void main(String[] args) throws Exception {
        RobustSingleton s1 = RobustSingleton.getInstance();
        RobustSingleton s2 = RobustSingleton.getInstance();

        System.out.println("Same instance? " + (s1 == s2)); // true

        // ---- Test Serialization ----
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(s1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        RobustSingleton s3 = (RobustSingleton) ois.readObject();

        System.out.println("After Serialization: " + (s1 == s3)); // true ✅

        // ---- Test Cloning ----
        try {
            RobustSingleton s4 = (RobustSingleton) s1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning prevented: " + e.getMessage()); // expected
        }

        // ---- Test Reflection ----
        try {
            java.lang.reflect.Constructor<RobustSingleton> constructor =
                    RobustSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            RobustSingleton s5 = constructor.newInstance(); // should throw RuntimeException
        } catch (Exception e) {
            System.out.println("Reflection prevented: " + e.getMessage());
        }
    }
}

