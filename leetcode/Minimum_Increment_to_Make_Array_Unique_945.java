package leetcode;

import java.util.Arrays;

public class Minimum_Increment_to_Make_Array_Unique_945 {
    // 1. 정렬. why? unique를 방지하기 위해 비교하기 편하기 위해.(오름차순)
    // 2. if ([i] <= [i-1]) 일 떄 2가지
    // 2-1. result에 [i-1]-[i]+1
    // 2-2. nums[i] = nums[i-1]+1
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return result;
    }
}
