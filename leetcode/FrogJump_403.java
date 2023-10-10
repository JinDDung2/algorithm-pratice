package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump_403 {
    // 인덱스는 0에서 시작
    // map에 {돌의 value, 돌의 idx} 저장
    // currIdx == n-1 -> true
    // k-1, k, k+1 재귀로 고려 prev > 1 -> k-1 k k+1 가능 / prev > 0 -> k, k+1 가능
    // k-1, k, k+1 점프할 때 돌인지 확인 -> -1을 돌이 아닌 경우라고 초기화할 것
    // 이전 단계 확인 -> prev > 0 일 경우만 이동 가능
    private boolean recursion(int currIdx, int[] stones, int size, Map<Integer, Integer> map, int prev, int[][] dp) {
        if (currIdx == -1) {
            return false;
        }

        if (currIdx == size - 1) {
            return true;
        }

        if (dp[currIdx][prev] != -1) {
            return dp[currIdx][prev] == 1 ? true : false;
        }

        boolean l = false, r = false, curr = false;

        if (prev > 1) {
            l = recursion(map.getOrDefault(stones[currIdx] + prev - 1, -1), stones, size, map, prev - 1, dp);
        }

        if (prev > 0) {
            curr = recursion(map.getOrDefault(stones[currIdx] + prev, -1), stones, size, map, prev, dp);
        }
        r = recursion(map.getOrDefault(stones[currIdx] + prev + 1, -1), stones, size, map, prev + 1, dp);

        dp[currIdx][prev] = (l || curr || r) ? 1 : 0;
        return l || curr | r;
    }

    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = stones.length;

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        int[][] dp = new int[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recursion(0, stones, n, map, 0, dp);
    }
}
