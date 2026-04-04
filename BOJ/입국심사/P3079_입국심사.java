package BOJ.입국심사;

import java.io.*;
import java.util.*;

// 3079. 입국심사 (미완)
public class P3079_입국심사 {
    static class Problem {

        int N, M;
        int[] times;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            times = new int[N];
            for (int i = 0; i < N; i++) {
                times[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(times);
            int maxTime = times[times.length - 1];
            long l = 1, r = (long) M * maxTime;
            long result = r;
            while (l < r) {
                long m = l + (r - l) / 2;
                long sum = 0;

                for (long t : times) {
                    sum += m / t;

                    if (sum >= M) break;
                }

                if (sum >= M) {
                    result = m;
                    r = m;
                } else {
                    l = m + 1;
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
