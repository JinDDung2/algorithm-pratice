package BOJ.trend;

import java.util.*;

public class P22251_빌런호석 {

    /**
     * 1. 0~9 까지 led선 담을 배열 만들기
     * 2. 1부터 N까지 값들을 X와 비교
     * 2-1) temp == X continue
     * 2-2) temp와 X 모두 K자릿수로 만들기. X = 1, K = 3 -> 001
     * 2-3) 한 자릿 수 씩 비교해서 다른 값들의 합 <= P 라면 경우의 수 추가
     */
    static class Problem {

        int[][] numbers = {
                {1, 1, 1, 1, 1, 1, 0}, // 0
                {0, 1, 1, 0, 0, 0, 0}, // 1
                {1, 1, 0, 1, 1, 0, 1}, // 2
                {1, 1, 1, 1, 0, 0, 1}, // 3
                {0, 1, 1, 0, 0, 1, 1}, // 4
                {1, 0, 1, 1, 0, 1, 1}, // 5
                {1, 0, 1, 1, 1, 1, 1}, // 6
                {1, 1, 1, 0, 0, 0, 0}, // 7
                {1, 1, 1, 1, 1, 1, 1}, // 8
                {1, 1, 1, 1, 0, 1, 1}, // 9
        };

        void solution() {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            int P = sc.nextInt();
            int X = sc.nextInt();

            int result = 0;
            String currFloor = String.format("%0" + K + "d", X);

            for (int temp = 1; temp <= N; temp++) {
                if (temp == X) continue;

                String tempFloor =  String.format("%0" + K + "d", temp);
                int differentCnt = 0;
                for (int i = 0; i < K; i++) {
                    int currDigit = currFloor.charAt(i) - '0';
                    int tempDigit = tempFloor.charAt(i) - '0';
                    differentCnt += countDifferences(numbers[currDigit], numbers[tempDigit]);

                }

                if (1 <= differentCnt && differentCnt <= P) result++;
            }

            System.out.println(result);

            sc.close();
        }

        int countDifferences(int[] nums1, int[] nums2) {
            int differentCnt = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i]) differentCnt++;
            }

            return differentCnt;
        }
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.solution();
    }

}
