class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeros = 0, result = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }
            r++;
            if (zeros > k) {
                while (zeros > k) {
                    if (nums[l] == 0) {
                        zeros--;
                    }
                    l++;
                }
            }
            result = Math.max(result, r - l);
        }
        return result;
    }
}
