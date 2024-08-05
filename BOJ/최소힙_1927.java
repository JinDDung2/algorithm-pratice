package BOJ;

import java.io.*;
import java.util.*;

public class 최소힙_1927 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            int data = Integer.parseInt(br.readLine());
            if (data > 0) {
                pq.add(data);
                continue;
            }

            if (pq.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(pq.poll());
            }
        }
    }

}
