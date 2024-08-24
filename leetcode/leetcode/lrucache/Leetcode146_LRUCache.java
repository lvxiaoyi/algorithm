package leetcode.lrucache;

import java.util.HashMap;
import java.util.Map;

class Leetcode146_LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    int size = 0;
    int capacity = 0;
    private DLinkNode head, tail;

    public Leetcode146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 判断缓存中是否有这个值
            // yes 返回节点，把这个节点移动到头部
            // no 返回-1
        DLinkNode node = cache.get(key);
        if (node != null){
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 查看缓存中是否有值，
        // 没有
        // 查看容量是否满,cache中放入这个值
        // yes
        // 把这个节点放入头部，移除末尾节点，
        // no
        // 把节点放入头部，size++
        // 有，覆盖这个值，把这个节点移动到头
        if (!cache.containsKey(key)){
            DLinkNode node = new DLinkNode(key, value);
            cache.put(key,node);
            addToHead(node);
            if (size >=capacity){
                DLinkNode tailValue = removeTail(tail);
                cache.remove(tailValue.key);
            }else {
                size++;
            }
        }else {
            DLinkNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }


    private final static class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;


        private DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        private DLinkNode() {

        }

    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(DLinkNode node) {
        DLinkNode res = node.prev;
        removeNode(res);
        return res;
    }


}