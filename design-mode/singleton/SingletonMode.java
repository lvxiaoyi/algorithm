package singleton;

/*
 * @Description: 单例模式：静态/饿汉式/懒汉式/线程安全懒汉/
 * @Author: zixin.lv
 * @Date: 2023/3/19 17:36
 */

import java.util.HashSet;
import java.util.Set;

public class SingletonMode {
    public static void main(String[] args) {

        //饿汉式
//        SingletonMode1 singletonMode1 = new SingletonMode1();
//        SingletonMode1 instance1 = singletonMode1.getInstance();
//        SingletonMode1 instance2 = singletonMode1.getInstance();
//        System.out.println("饿汉式两个实例是否相等：" + (instance1.equals(instance2)));


        //懒汉式
//        SingletonMode2 instance3 = SingletonMode2.getInstance();
//        SingletonMode2 instance4 = SingletonMode2.getInstance();
//        System.out.println("懒汉式两个实例是否相等：" + (instance3.equals(instance4)));

        //验证懒汉式不安全：在开始的打印地址中，前两组的地址很大概率不一致
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                System.out.println(SingletonMode2.getInstance());
//            }).start();
//        }
//
//        // 部分线程安全的懒汉式
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                SingletonMode3 instance = SingletonMode3.getInstance();
//                System.out.println(instance);
//            }).start();
//        }

        Set<SingletonMode4> extracted = extracted();
        while (extracted.size() == 1) {
            extracted = extracted();
        }
        extracted.forEach(System.out::println);

    }

    private static Set<SingletonMode4> extracted() {
        Set<SingletonMode4> container = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonMode4 instance = SingletonMode4.getInstance();
                container.add(instance);
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return container;
    }


}


