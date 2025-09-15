package singleton;

public class SynchronizedSingleton {
    private static volatile SynchronizedSingleton instance;

    private SynchronizedSingleton() {}


    /*
Thread-1 enters getInstance().

instance == null → true.

Enters synchronized block → creates new SynchronizedSingleton() (object A).

Thread-2 almost at the same time enters getInstance().

It checked if (instance == null) before Thread-1 assigned the object.

So it also sees null.

Waits until Thread-1 exits the synchronized block.

Thread-2 now enters the synchronized block.

No second if (instance == null) → blindly creates new SynchronizedSingleton() (object B).

👉 Final state: instance points to object B, but two different objects were created (object A and B).*/

    public static SynchronizedSingleton getInstance() {
        if (instance == null) { // first check
            synchronized (SynchronizedSingleton.class) {
                    instance = new SynchronizedSingleton();
            }
        }
        return instance;
    }

    public static SynchronizedSingleton getInstance1() {
        if (instance == null) { // first check
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) { // ✅ second check
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
            Runnable task = () -> {
                SynchronizedSingleton obj = SynchronizedSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() +
                        " -> " + System.identityHashCode(obj));
            };

            Thread t1 = new Thread(task, "Thread-1");
            Thread t2 = new Thread(task, "Thread-2");

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }


}

