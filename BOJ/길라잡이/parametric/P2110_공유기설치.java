package BOJ.길라잡이.parametric;

import java.io.*;
import java.util.*;

public class P2110_공유기설치 {

    static class Problem {

        int N, C;
        int[] house;

        /**
         * 최댓값 -> upper bound
         */
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            house = new int[N];
            for (int i = 0; i < N; i++) {
                house[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(house);

            int result = 0;
            int l = 0, r = house[house.length - 1];
            while (l <= r) {
                int m = l + (r - l) / 2;
                int cnt = calculate(m);

                if (cnt >= C) {
                    result = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            br.close();
        }

        int calculate(int dist) {
            int cnt = 1;
            int prev = house[0];
            for (int i = 1; i < N; i++) {
                if (house[i] >= prev + dist) {
                    cnt++;
                    prev = house[i];
                }
            }

            return cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
