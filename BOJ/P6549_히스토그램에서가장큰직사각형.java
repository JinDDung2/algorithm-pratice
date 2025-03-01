package BOJ;

import java.io.*;
import java.util.*;

public class P6549_히스토그램에서가장큰직사각형 {
    static class Problem {
        /**
         * 직사각형의 넓이가 int타입을 넘어갈 수 있음 -> long
         * 스택에 인덱스를 넣으면서, 현재 높이가 top보다 낮다면 pop해서 직사각형 넓이 기존 최댓값과 비교 후 저장
         */
        String solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            StringBuilder sb = new StringBuilder();

            while (!(input = br.readLine()).equals("0")) {
                StringTokenizer st = new StringTokenizer(input);
                int n = Integer.parseInt(st.nextToken()); // 첫 번째 값이 n

                int[] heights = new int[n + 1]; // 마지막에 0을 추가하기 위해 n+1 크기 할당
                for (int i = 0; i < n; i++) {
                    heights[i] = Integer.parseInt(st.nextToken());
                }

                heights[n] = 0; // 마지막 인덱스에 0 추가 (강제 pop 유도)
                sb.append(getLargestRectangle(heights, n)).append("\n");
            }

            return sb.toString();
        }

        long getLargestRectangle(int[] heights, int n) {
            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int currHeight = heights[i];

                while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                    int idx = stack.pop();
                    int h = heights[idx];
                    int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, (long) h * w);
                }

                stack.push(i);
            }

            return maxArea;
        }
    }

    String solutionV2() {
        return "";
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
