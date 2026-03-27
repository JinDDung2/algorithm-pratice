package leetcode;

// 494. Target Sum
public class TargetSum_494 {
    // 각 숫자에 + or - 붙여서 target 만드는 경우의 수
    // 브루트포스 2^n: 안됨
    // 플러스(P) 집합과 마이너스(M)집합이 존재
    // P - M = target
    // P + M = totalSum
    // 2P = target + totalSum
    // P = (target + totalSum) / 2
    // dp[i] = 합이 i가 되는 경우의 수
    public int findTargetSumWaysV2(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 예외조건 2개: 정수가 아니거나, target > totalSum
        if ((target + totalSum) % 2 != 0) return 0;
        if (Math.abs(target) > totalSum) return 0;

        int p = (target + totalSum) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int s = p; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[p];
    }

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
