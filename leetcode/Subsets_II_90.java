package leetcode;

import java.util.*;

// 90. Subsets II
public class Subsets_II_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue; // skip duplicates
            int num = nums[i];
            temp.add(num);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}