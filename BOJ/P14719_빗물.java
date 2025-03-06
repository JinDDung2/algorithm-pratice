package BOJ;

import java.io.*;
import java.util.*;

public class P14719_빗물 {
    static class Problem {
        int solution() throws IOException {

            // 해당 지점에서 왼쪽 블럭 최대 높이와 오른쪽 블럭 최대 높이 파악하기
            // O(W * W): 250,000
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int totalWater = 0;

            for (int i = 1; i < W - 1; i++) {
                int leftMaxHeight = 0, rightMaxHeight = 0;

                for (int j = 0; j < i; j++) {
                    leftMaxHeight = Math.max(leftMaxHeight, arr[j]);
                }

                for (int j = i + 1; j < W; j++) {
                    rightMaxHeight = Math.max(rightMaxHeight, arr[j]);
                }

                if (arr[i] < leftMaxHeight && arr[i] < rightMaxHeight) {
                    totalWater += Math.min(leftMaxHeight, rightMaxHeight) - arr[i];
                }
            }

            return totalWater;
        }
    }
    public static void main(String[] args) throws IOException  {
        Problem problem = new Problem();
        System.out.println(problem.solution());
    }
}
