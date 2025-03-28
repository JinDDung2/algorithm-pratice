package BOJ;

import java.io.*;
import java.util.Arrays;

public class P2138_전구와스위치 {
    static class Problem {
        int N;
        char[] origin;
        char[] target;

        // i-1이 목표와 다르면 i번째를 눌러 맞춘다.
        // 케이스는 2개
        //  0번째 전구를 끈 상태에서 시작
        //  0번째 전구를 킨 상태에서 시작
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            origin = br.readLine().toCharArray();
            target = br.readLine().toCharArray();

            // case 1
            char[] case1 = origin.clone();
            int cnt1 = solve(case1, false);

            // case 2
            char[] case2 = origin.clone();
            toggle(case2, 0);
            int cnt2 = solve(case2, true);

            int result = Integer.MAX_VALUE;
            if (cnt1 != -1) result = Math.min(result, cnt1);
            if (cnt2 != -1) result = Math.min(result, cnt2);

            bw.write(String.valueOf(result == Integer.MAX_VALUE ? -1 : result));
            bw.close();
            br.close();

        }

        int solve(char[] arr, boolean pressed) {
            int cnt = pressed ? 1 : 0;

            for (int i = 1; i < N; i++) {
                if (arr[i - 1] != target[i - 1]) {
                    toggle(arr, i);
                    cnt++;
                }
            }

            if (Arrays.equals(arr, target)) return cnt;
            return -1;
        }

        void toggle(char[] arr, int idx) {
            for (int i = idx - 1; i <= idx + 1; i++) {
                if (i >= 0 && i < N) {
                    arr[i] = arr[i] == '0' ? '1' : '0';
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
