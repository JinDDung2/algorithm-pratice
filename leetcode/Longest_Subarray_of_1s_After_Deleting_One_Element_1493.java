package leetcode;

public class Longest_Subarray_of_1s_After_Deleting_One_Element_1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeros = 0, result = 0;
        int l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }
            r++;
            while (zeros > 1) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            result = Math.max(result, r - l - 1);
        }

        return result == n ? result - 1 : result;
    }
}
