package leetcode;

// 64. Minimum Path Sum
public class MinPathSum_64 {
    // 양수만 존재하며 0,0 -> n-1,m-1까지 이동
    // 이동 중에 값들의 최소 값
    // 좌측, 상방 이동이 필요할까? X
    // 우측, 하방 이동만 필요 O
    // 그럼 DP로 누적 최소값 초기화
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        // 첫째 행 할당
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 첫째 열 할당
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 나머지 칸
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }
}
