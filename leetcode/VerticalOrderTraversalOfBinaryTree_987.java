package leetcode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree_987 {

    Map<Integer, TreeMap<Integer, List<Integer>>> map = new HashMap<>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        fill(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (int x = min; x <= max; x++) {
            List<Integer> list = new ArrayList<>();

            for (List<Integer> l : map.get(x).values()) {
                Collections.sort(l);
                list.addAll(l);
            }

            result.add(list);
        }

        return result;
    }

    public void fill(TreeNode cur, int y, int x) {
        if (cur == null) return;

        min = Math.min(min, x);
        max = Math.max(max, x);

        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new ArrayList<>());
        map.get(x).get(y).add(cur.val);

        fill(cur.left, y + 1, x - 1);
        fill(cur.right, y + 1, x + 1);
    }

}
