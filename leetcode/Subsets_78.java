package leetcode;

import java.util.*;

// 78. Subsets
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            temp.add(num);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
