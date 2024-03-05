package programmas.kakao;

import java.util.*;

// 2020 KAKAO BLIND RECRUITMENT 길찾기 게임

public class 길찾기게임 {
    class Node {
        int val;
        int x;
        Node left;
        Node right;

        Node(int val, int x) {
            this.val = val;
            this.x = x;
        }
    }

    int maxY = Integer.MIN_VALUE;
    int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        Node root = null;

        TreeMap<Integer, TreeMap<Integer, Node>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] n = nodeinfo[i];
            map.putIfAbsent(n[1], new TreeMap<>());
            map.get(n[1]).put(n[0], new Node(i + 1, n[0]));
            if (n[1] > maxY) {
                maxY = n[1];
                root = map.get(n[1]).get(n[0]);
            }
        }

        buildTree_recursion(root, null, null, map, maxY);

        int[] arr = new int[nodeinfo.length];
        getPre(arr, root);
        answer[0] = arr;

        arr = new int[nodeinfo.length];
        idx = 0;
        getPost(arr, root);
        answer[1] = arr;

        return answer;
    }

    private void buildTree_recursion(Node node, Integer min, Integer max, TreeMap<Integer, TreeMap<Integer, Node>> map,
            int depth) {
        Integer next = map.ceilingKey(depth - 1);
        System.out.println(depth + " - " + next);
        if (next == null)
            return;

        Integer key = map.get(next).floorKey(node.x - 1);
        if (key != null && (min == null || key > min)) {
            node.left = map.get(next).get(key);
            buildTree_recursion(node.left, min, node.x, map, next);
        }
        key = map.get(next).ceilingKey(node.x + 1);
        if (key != null && (max == null || key < max)) {
            node.right = map.get(next).get(key);
            buildTree_recursion(node.right, node.x, max, map, next);
        }
    }

    private void getPre(int[] pre, Node node) {
        if (node == null)
            return;

        pre[idx++] = node.val;
        getPre(pre, node.left);
        getPre(pre, node.right);
    }

    private void getPost(int[] post, Node node) {
        if (node == null)
            return;

        getPost(post, node.left);
        getPost(post, node.right);
        post[idx++] = node.val;
    }
}
