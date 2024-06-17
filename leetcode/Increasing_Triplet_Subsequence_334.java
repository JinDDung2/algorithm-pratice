package leetcode;

public class Increasing_Triplet_Subsequence_334 {
    // 1. 어떤 기준보다 작은수(중간), 중간보다 더 작은수(왼쪽) -> 총 2개 변수 필요
    // 2. 반복 -> nums[i] > left && nums[i] > mid
    // 다르게 풀면
    // 2-1. if (left >= nums[i]) left = num
    // 2-2. else if (mid >= nums[i] mid = num
    // 2-3. else true
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= left) {
                left = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
