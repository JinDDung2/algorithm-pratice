package BOJ;

import java.io.*;
import java.util.Arrays;

public class P15989_123더하기4 {

    static class Problem {
        String solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            int[] result = new int[T];
            int maxNum = 0;

            for (int i = 0; i < T; i++) {
                result[i] = Integer.parseInt(br.readLine());
                maxNum = Math.max(maxNum, result[i]);
            }

            // dp[i][j]: i를 1~j 숫자로 나타내는 방법의 수
            int[][] dp = new int[maxNum + 1][4];
            dp[0][1] = dp[0][2] = dp[0][3] = 1;

            for (int i = 1; i <= maxNum; i++) {
                for (int j = 1; j <= 3; j++) {
                    // j를 포함하지 않는 경우
                    dp[i][j] = dp[i][j - 1];
                    // j를 포함하는 경우
                    if (i >= j) {
                        dp[i][j] += dp[i - j][j];
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                sb.append(dp[num][3]).append("\n");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
