package BOJ;

import java.io.*;
import java.util.*;

// [S3] 3273. 두 수의 합
public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int target = Integer.parseInt(br.readLine());

        Arrays.sort(data);
        int l = 0, r = data.length - 1;
        int cnt = 0;

        while (l < r) {
            int sum = data[l] + data[r];
            if (sum == target) {
                cnt++;
                l++;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(cnt);
    }
}
