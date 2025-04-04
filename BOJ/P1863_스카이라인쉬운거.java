package BOJ;

import java.io.*;
import java.util.*;

public class P1863_스카이라인쉬운거 {
    static class Problem {
        /**
         * 높이 비교
         * prev < curr ? 스택 추가
         * prev == curr ? 패스(같은 건물 간주)
         * prev > curr ? 스택에서 제거 + 갯수 추가
         */
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int cnt = 0;

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // x 무시
                int h = Integer.parseInt(st.nextToken());

                // 스택에서 현재 높이보다 큰 건물은 pop하고, cnt++;
                while (!stack.isEmpty() && stack.peek() > h) {
                    stack.pop();
                    cnt++;
                }

                if (stack.isEmpty() || stack.peek() < h) {
                    stack.add(h);
                }
            }

            // 남아있는 높이들 모두 count
            while (!stack.isEmpty()) {
                if (stack.pop() != 0) cnt++;
            }

            bw.write(String.valueOf(cnt));
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
