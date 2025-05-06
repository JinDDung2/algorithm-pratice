package BOJ.길라잡이.dp;

import java.io.*;
import java.util.*;

public class P1912_연속합 {

    static class Problem {

        int N;
        int[] data;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            data = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            int result = data[0];
            int temp = data[0];
            for (int i = 1; i < N; i++) {
                temp = Math.max(data[i], temp + data[i]);
                result = Math.max(result, temp);
            }

            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
