package leetcode;

// 746. Min Cost Climbing Stairs
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        final int N = cost.length;
        int[] dp = new int[N];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[N - 2], dp[N - 1]);
    }
}
