package test;

import java.util.concurrent.ConcurrentSkipListSet;

public class SingletonMode {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> container = new ConcurrentSkipListSet<>();
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    SingletonMode4 instance = SingletonMode4.getInstance();
                    container.add(instance.toString());
                }).start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (container.size() != 1) {
                container.forEach(System.out::println);
                container.clear();
                flag = false;
            }
        }
        container.forEach(System.out::println);
    }
}

class SingletonMode4 {
    private static volatile SingletonMode4 instance;

    private SingletonMode4() {
    }

    public static SingletonMode4 getInstance() {
        if (instance == null) {
            synchronized (SingletonMode4.class) {
                if (instance == null) {
                    instance = new SingletonMode4();
                }
            }
        }
        return instance;
    }
}
