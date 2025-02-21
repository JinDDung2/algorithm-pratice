package BOJ;

import java.io.*;
import java.util.*;

public class P2493_탑 {

    static class Problem {
        int[] solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] result = new int[N];

            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                int currHeight = data[i];

                // 현재 탑이 스택 탑보다 높으면 빼기
                while (!stack.isEmpty() && currHeight > stack.peek()[0]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) { // 신호 받을 탑이 있는 경우 -> 해당 탑의 인덱스 추가
                    result[i] = stack.peek()[1];
                } else { // 신호 받을 탑이 없는 경우 -> 0
                    result[i] = 0;
                }

                // 스택에 탑 추가하기
                stack.push(new int[]{data[i], i + 1});
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(Arrays.toString(p.solution()));
    }
}
