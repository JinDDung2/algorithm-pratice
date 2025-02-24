package BOJ;

import java.util.*;
import java.io.*;

public class P17298_오큰수 {
    static class Problem {
        String solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] result = new int[N];
            StringBuilder sb = new StringBuilder();

            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                int currNum = data[i];
                while(!stack.isEmpty() && stack.peek()[0] < currNum) {
                    int[] nums = stack.pop();
                    int ageIdx = nums[1];
                    result[ageIdx] = currNum;
                }

                stack.add(new int[]{currNum, i});
            }

            while (!stack.isEmpty()) {
                int[] nums = stack.pop();
                int ageIdx = nums[1];
                result[ageIdx] = -1;
            }

            for (int n : result) {
                sb.append(n).append(" ");
            }

            return sb.toString().trim();
        }
    }
    public static void main(String[] args) throws IOException  {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
