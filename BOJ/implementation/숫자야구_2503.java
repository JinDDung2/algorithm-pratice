package BOJ.implementation;

import java.io.*;
import java.util.*;

public class 숫자야구_2503 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int strikes = Integer.parseInt(st.nextToken());
            int balls = Integer.parseInt(st.nextToken());
            arr[i] = new int[] { num, strikes, balls };
        }

        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == i)
                    continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == j || k == i)
                        continue;
                    if (valid(String.valueOf(i * 100 + j * 10 + k), arr)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static boolean valid(String num, int[][] arr) {
        for (int i = 0; i < N; i++) {
            int[] nums = arr[i];
            int strikes = 0, balls = 0;
            String target = String.valueOf(nums[0]);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (num.charAt(j) == target.charAt(k)) {
                        if (k == j)
                            strikes++;
                        else
                            balls++;
                    }
                }
            }

            if (strikes != nums[1] || balls != nums[2])
                return false;
        }

        return true;
    }
}
