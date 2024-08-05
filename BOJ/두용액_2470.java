package BOJ;

import java.io.*;
import java.util.*;

// [G5] 2470. 두 용액
public class 두용액_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        int l = 0, r = N - 1;
        int minSum = Math.abs(data[l] + data[r]);
        int[] result = { data[l], data[r] };

        while (l < r) {
            int sum = data[l] + data[r];
            if (minSum > Math.abs(sum)) {
                minSum = Math.abs(sum);
                result[0] = data[l];
                result[1] = data[r];
                if (sum == 0)
                    break;
            }

            if (sum > 0)
                r--;
            else
                l++;
        }

        System.out.printf("%d %d", result[0], result[1]);
        br.close();
    }
}
