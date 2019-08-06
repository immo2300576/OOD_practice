import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class HashMap {
    public static void main(String[] argv) {
        HashMap map = new HashMap();
        map.put(1,5);
        map.put(45,500);
        map.put(435,222);
        map.put(1025,222);
        System.out.println("First Time");
        for (Integer k : map.keySet()) {
            System.out.println("Map " + k + " -> " + map.get(k));
        }
        map.remove(435);
        System.out.println("Second Time");
        for (Integer k : map.keySet()) {
            System.out.println("Map " + k + " -> " + map.get(k));
        }
    }
    private class ListNode {
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int bin_size = 1024;
    List<ListNode> lut;
    public HashMap() {
        lut = new ArrayList<>();
        for (int i = 0; i < bin_size; i++)
            lut.add(new ListNode(-1,-1)); /* add dummy node */
    }
    /* private hash function */
    private int hashcode(int key) {
        return key%bin_size;
    }
    /* HashMap get function */
    public int get(int key) {
        int hashkey = hashcode(key);
        ListNode cur = lut.get(hashkey);
        while (cur != null) {
            if (cur.key == key) return cur.value;
            cur = cur.next;
        }
        return -1;
    }
    /* HashMap keySet function */
    public Set<Integer> keySet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bin_size; i++) {
            ListNode cur = lut.get(i);
            while (cur != null) {
                if (cur.key != -1) set.add(cur.key);
                cur = cur.next;
            }
        }
        return set;
    }
    /* HashMap remove function */
    public boolean remove(int key) {
        int hashkey = hashcode(key);
        ListNode pre = lut.get(hashkey);
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.key == key) {
                pre.next = cur.next;
                return true;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return false;
    }
    /* HashMap put function */
    public void put(int key, int value) {
        int hashkey = hashcode(key);
        ListNode pre = lut.get(hashkey);
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = new ListNode(key, value);
    }
}