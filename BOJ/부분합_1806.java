package BOJ;

import java.io.*;
import java.util.*;

// [G4] 1806. 부분 합
public class 부분합_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] += Integer.parseInt(st.nextToken());
        }
        int result = Integer.MAX_VALUE, l = 0, r = 1, sum = data[0];

        while (true) {
            if (sum >= M) {
                result = Math.min(result, (r - l));
                sum -= data[l++];
            } else if (r == N) {
                break;
            } else {
                sum += data[r++];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
        br.close();
    }
}
