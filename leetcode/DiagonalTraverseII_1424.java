package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverseII_1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxKey = 0;
        int n = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
                maxKey = Math.max(maxKey, i + j);
                n++;
            }
        }

        // System.out.println(map);
        int[] result = new int[n];
        int idx = 0;
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            for (int v : value) result[idx++] = v;
        }

        return result;
    }
}
