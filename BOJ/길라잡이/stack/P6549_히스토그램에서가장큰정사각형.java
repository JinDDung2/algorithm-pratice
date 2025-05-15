package BOJ.길라잡이.stack;

import java.io.*;
import java.util.*;

public class P6549_히스토그램에서가장큰정사각형 {

    static class Problem {

        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());

                if (n == 0) break;

                int[] heights = new int[n];
                for (int i = 0; i < n; i++) {
                    heights[i] = Integer.parseInt(st.nextToken());
                }

                bw.write(getMaxAreaRectangle(heights, n) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        long getMaxAreaRectangle(int[] heights, int n) {
            long maxArea = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int h = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, (long) width * h);
                }
                stack.push(i);
            }

            // 마지막 값이 큰 값이라 스택에 값이 남아 있는 경우
            while (!stack.isEmpty()) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) width * h);
            }

            return maxArea;
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
