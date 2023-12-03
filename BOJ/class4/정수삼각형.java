package BOJ.class4;

import java.io.*;
import java.util.*;

// [S1] 1932. 정수삼각형
// dp -> dp[i] = Math.max(dp[i-1][j], dp[i-1][j-1]
class 정수삼각형 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                arr[i][j + 1] = Integer.parseInt(line[j]);
            }
        }

        // for (int[] ar : arr) {
        // System.out.println(Arrays.toString(ar));
        // }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
            }
        }

        int rst = 0;
        for (int i = 1; i <= N; i++) {
            rst = Math.max(arr[N][i], rst);
        }

        System.out.println(rst);
    }
}