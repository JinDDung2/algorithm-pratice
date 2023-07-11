package BOJ.greedy_implemention;

import java.io.*;
import java.util.*;

// [S5] 짐 챙기는 숌
public class Cob1817 {
    private int box = 1;

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        if (n == 0) {
            System.out.println(0);
            return ;
        }

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
            stack.add(Integer.valueOf(st.nextToken()));
        }
        int total = 0;
        while (!stack.empty()) {
            int w = (int) stack.pop();
            total += w;
            if (total > m) {
                box++;
                total = w;
            }
        }
        System.out.println(box);
    }

    public static void main(String[] args) throws IOException{
        new Cob1817().solution();
    }
}
