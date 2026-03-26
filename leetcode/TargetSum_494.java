package leetcode;

// 494. Target Sum
public class TargetSum_494 {
    // 각 숫자에 + or - 붙여서 target 만드는 경우의 수
    // 브루트포스 2^n: 안됨
    // 2차원배열을 만들어 dp를 만들기?
    // dp[i][sum] = 경우의 수
    // dp[i][sum + nums[i]] += dp[i - 1][sum]
    // dp[i][sum - nums[i]] += dp[i - 1][sum]
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // dp 초기화
        int[][] dp = new int[nums.length][2 * totalSum + 1];
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        // dp 값 채우기
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[i - 1][sum + totalSum] > 0) {
                    dp[i][sum + nums[i] + totalSum] += dp[i - 1][sum + totalSum];
                    dp[i][sum - nums[i] + totalSum] += dp[i - 1][sum + totalSum];
                }
            }
        }

        return Math.abs(target) > totalSum ? 0 : dp[nums.length - 1][target + totalSum];
    }
}
