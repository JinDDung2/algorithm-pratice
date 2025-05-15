package BOJ.길라잡이.stack;

import java.io.*;
import java.util.*;

public class P2493_탑 {

    static class Problem {

        int N;
        int[] tops;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            tops = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tops[i] = Integer.parseInt(st.nextToken());
            }

            int[] answer = new int[N];
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                int currHeight = tops[i];

                while (!stack.isEmpty() && currHeight > stack.peek()[1]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    answer[i] = stack.peek()[0];
                }

                stack.push(new int[]{i + 1, tops[i]});
            }

            for (int idx : answer) {
                bw.write(idx + " ");
            }
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
