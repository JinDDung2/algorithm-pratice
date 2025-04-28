package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P1182_부분수열의합 {
    static class Problem {
        int result = 0;
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(arr, 0, 0, 0, s);

            System.out.println(result);
        }

        void backtracking(int[] arr, int cnt, int idx, int sum, int s) {
            if (idx == arr.length) {
                if (sum == s && cnt != 0) result++;
                return;
            }

            backtracking(arr, cnt + 1, idx + 1, sum + arr[idx], s); // 해당 값 포함
            backtracking(arr, cnt, idx + 1, sum, s); // 해당 값 패스
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
