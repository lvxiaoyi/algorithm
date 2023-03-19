package singleton;

public class SingletonMode3 {
    private  static SingletonMode3 instance = null;

    private SingletonMode3() {

    }

    public static synchronized SingletonMode3 getInstance() {
        if (instance == null) {
            instance = new SingletonMode3();
        }
        return instance;
    }

}