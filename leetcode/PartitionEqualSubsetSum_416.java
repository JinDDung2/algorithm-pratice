package leetcode;

// 416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum_416 {
    // 두개의 subset의 합이 같아야 한다 -> a + a = 2a -> 짝수여야 한다.
    // 그렇다면 두 개의 subset의 값은 (total sum / 2)
    // dp[i] = 해당하는 값을 만들 수 있는가?
    // 순회방향 앞->뒤 : 업데이트된 dp값 사용 = 동일한 숫자 여러번 사용
    // 순회방향 뒤->앞 : 이전 상태만 참조
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;

        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[targetSum]) return true;
            }
        }

        return dp[targetSum];
    }
}
