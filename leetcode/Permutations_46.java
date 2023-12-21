package leetcode;

import java.util.*;

// 46. Permutations
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (temp.contains(num))
                continue;
            temp.add(num);
            backtrack(nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
