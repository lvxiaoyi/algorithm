package leetcode.lrucache;

public class MainTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        // 返回  1
        System.out.println(cache.get(1));
        // 该操作会使得密钥 2 作废
        cache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        // 该操作会使得密钥 1 作废
        cache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println(cache.get(1));
        // 返回  3
        System.out.println(cache.get(3));
        // 返回  4
        System.out.println(cache.get(4));

    }
}
