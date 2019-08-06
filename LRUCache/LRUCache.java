import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static void main(String[] argv) {
        LRUCache map = new LRUCache(3);
        map.put(1,5);
        map.put(45,500);
        map.put(435,222);
        map.put(1025,222);
        System.out.println("Cache data " + 1 + " -> " + map.get(1));
        System.out.println("Cache data " + 45 + " -> " + map.get(45));
        System.out.println("Cache data " + 435 + " -> " + map.get(435));
        System.out.println("Cache data " + 1025 + " -> " + map.get(1025));
    }
    private class DListNode {
        DListNode prev;
        DListNode next;
        int value;
        int key;
        public DListNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
    private DListNode dummy;
    private int size;
    private int maxSize;
    private Map<Integer, DListNode> map;
    public LRUCache(int capacity) {
        dummy = new DListNode(0, 0);
        dummy.next = dummy;
        dummy.prev = dummy;
        maxSize = capacity;
        size = 0;
        map = new HashMap<Integer, DListNode>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DListNode n = map.get(key);
            put(key, n.value);
            return n.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DListNode node = map.get(key);
            DListNode pre = node.prev;
            DListNode nxt = node.next;
            pre.next = nxt;
            nxt.prev = pre;
            map.remove(node.key);
            // System.out.println("remove " + node.key);
            size--;
        }
        else if (size == maxSize) {
            DListNode node = dummy.prev;
            DListNode pre = node.prev;
            pre.next = dummy;
            dummy.prev = pre;
            map.remove(node.key);
            // System.out.println("remove " + node.key);
            size--;
        }
        DListNode nxt = dummy.next;
        DListNode newnode = new DListNode(key, value);
        // System.out.println("add " + newnode.key);
        dummy.next = newnode;
        newnode.next = nxt;
        nxt.prev = newnode;
        newnode.prev = dummy;
        map.put(key, newnode);
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */