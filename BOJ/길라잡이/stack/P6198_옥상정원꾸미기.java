package BOJ.길라잡이.stack;

import java.io.*;
import java.util.*;

public class P6198_옥상정원꾸미기 {

    static class Problem {

        int N;
        int[] buildings;

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            buildings = new int[N];
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(br.readLine());;
            }

            Stack<Integer> stack = new Stack<>();
            long totalViewCount = 0;

            for (int i = 0; i < N; i++) {
                int currHeight = buildings[i];

                while (!stack.isEmpty() && currHeight >= stack.peek()) {
                    stack.pop();
                }

                totalViewCount += stack.size();

                stack.push(currHeight);
            }

            bw.write(String.valueOf(totalViewCount));
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
