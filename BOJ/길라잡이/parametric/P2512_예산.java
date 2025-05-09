package BOJ.길라잡이.parametric;

import java.io.*;
import java.util.*;

public class P2512_예산 {

    static class Problem {

        int N, M;
        int[] budget;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            budget = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                budget[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            int result = 0;
            int total = Arrays.stream(budget).sum();
            if (total <= M) {
                for (int b : budget) {
                    result = Math.max(result, b);
                }
            } else {
                int l = 0, r = M;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    int sum = calculate(m);

                    if (sum <= M) {
                        result = Math.max(result, m);
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }


            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int calculate(int target) {
            int sum = 0;
            for (int b : budget) {
                sum += Math.min(b, target);
            }

            return sum;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
