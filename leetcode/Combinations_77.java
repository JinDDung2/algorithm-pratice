package leetcode;

import java.util.*;

// 77. Combinations
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int k, int start, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(n, k, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}