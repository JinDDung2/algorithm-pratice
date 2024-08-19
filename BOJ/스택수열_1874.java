package BOJ;

import java.io.*;
import java.util.*;

// [S2] 1874. 스택 수열

public class 스택수열_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int curr = 1;
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            int target = data[i];

            while (curr <= target) {
                stack.push(curr++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }

}
