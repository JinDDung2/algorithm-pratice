package leetcode;

import java.util.*;

class LRUCache {
    class Node {
        private int k;
        private int v;
        private Node next;
        private Node prev;

        Node() {};
        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    Map<Integer, Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        removeNode(node);
        moveToHead(node);

        return node.v;
    }

    
    public void put(int key, int value) {
        // 이미 있으면 다시 넣기
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.v = value;
            removeNode(node);
            moveToHead(node);

            return;
        }
        // 최대크기와 같을 경우
        if (map.size() == cap) {
            Node node = tail.prev;
            map.remove(node.k);
            removeNode(node);
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        moveToHead(node);
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    };

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    };
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
