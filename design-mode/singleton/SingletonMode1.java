package singleton;
/*
 * @Description: 饿汉式
 * @Author: zixin.lv
 * @Date: 2023/3/19 17:47
 */

public class SingletonMode1 {

    private static SingletonMode1 instance = new SingletonMode1();

    SingletonMode1() {

    }

    public SingletonMode1 getInstance() {
        return instance;
    }

}