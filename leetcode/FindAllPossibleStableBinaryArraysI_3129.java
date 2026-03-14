package leetcode;

public class FindAllPossibleStableBinaryArraysI_3129 {
    final int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][] dp0 = new int[zero + 1][one + 1];
        int[][] dp1 = new int[zero + 1][one + 1];
        final int L = limit + 1;

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp0[i][0] = 1;
        }

        for (int i = 1; i <= Math.min(one, limit); i++) {
            dp1[0][i] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {

                dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j] - (i >= L ? dp1[i - L][j] : 0)) % MOD;
                dp1[i][j] = (dp0[i][j - 1] + dp1[i][j - 1] - (j >= L ? dp0[i][j - L] : 0)) % MOD;

                dp0[i][j] = (dp0[i][j] + MOD) % MOD;
                dp1[i][j] = (dp1[i][j] + MOD) % MOD;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % MOD;
    }
}
