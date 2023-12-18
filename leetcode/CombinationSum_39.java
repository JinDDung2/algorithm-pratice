package leetcode;

import java.util.*;

// 39. Combination Sum
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int sum, int idx, List<Integer> temp,
            List<List<Integer>> result) {
        if (idx == candidates.length || sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int num = candidates[i];
            temp.add(num);
            backtrack(candidates, target, sum + num, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
