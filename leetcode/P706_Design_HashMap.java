package leetcode;

public class P706_Design_HashMap {

    /*private class ListNode {
        int key, value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private ListNode[] map;
    private static final int SIZE = 10_000;

    public MyHashMap() {
        map = new ListNode[SIZE];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % map.length;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (map[idx] == null) {
            map[idx] = new ListNode(key, value);
            return;
        }

        ListNode node = map[idx];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }

            if (node.next == null) {
                break;
            }

            node = node.next;
            node.next = new ListNode(key, value);
        }
    }

    public int get(int key) {
        int idx = hash(key);
        ListNode node = map[idx];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        ListNode node = map[idx];
        if (node == null) {
            return;
        }

        if (node.key == key) {
            map[idx] = node.next;
            return;
        }

        while(node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }*/
}
