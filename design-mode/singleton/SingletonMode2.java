package singleton;

public class SingletonMode2 {
    private static SingletonMode2 instance = null;

    private SingletonMode2() {

    }

    public static SingletonMode2 getInstance() {
        return instance == null ? instance = new SingletonMode2() : instance;
    }


}