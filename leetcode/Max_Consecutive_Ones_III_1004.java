package leetcode;

class Max_Consecutive_Ones_III_1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;
        int l = 0, r = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }
            r++;
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
        }

        return r - l;
    }
}
