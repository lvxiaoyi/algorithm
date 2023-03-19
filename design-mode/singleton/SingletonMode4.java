package singleton;

public class SingletonMode4 {
    private static SingletonMode4 instance = null;

    private SingletonMode4() {

    }

    public static synchronized SingletonMode4 getInstance() {
        if (instance == null) {
            synchronized (SingletonMode4.class) {
                instance = new SingletonMode4();
            }
        }
        return instance;
    }

}