package BOJ;

import java.io.*;
import java.util.*;

public class P2467_용액 {

    static class Problem {

        /**
         * 두 값의 합이 0과 가장 가까운 두 인덱스를 구하기
         * N <= 100,000 -> 이중 For문 시간초과
         * 투포인터
         * N개의 용액들의 특성값은 모두 서로 다름 == 중복값 없음
         * 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력
         */
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine()); // <= 100,000
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 두 값이 0과 비교할 target
            // 출력값은 인덱스가 아닌 두 값.
            int l = 0, r = arr.length - 1;
            int[] result = new int[2]; // 두 값을 담을 배열
            int minSum = Integer.MAX_VALUE;

            while (l < r) {
                int sum = arr[l] + arr[r];

                if (minSum > Math.abs(sum)) {
                    minSum = Math.abs(sum);
                    result[0] = arr[l];
                    result[1] = arr[r];
                }

                if (sum == 0) break;
                else if (sum > 0) r--;
                else l++;
            }

            bw.write(result[0] + " " + result[1]);
            br.close();
            bw.flush();
            bw.close();
        }

    }

    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
