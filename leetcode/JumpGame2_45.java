package leetcode;

// 5. Jump Game II
public class JumpGame2_45 {
    public int jump(int[] nums) {
        int cnt = 0, currEnd = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (currFarthest >= nums.length - 1) {
                cnt++;
                break;
            }
            if (i == currEnd) {
                currEnd = currFarthest;
                cnt++;
            }
        }
        return cnt;
    }
}
