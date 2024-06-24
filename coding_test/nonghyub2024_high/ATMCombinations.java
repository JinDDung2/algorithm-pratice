package coding_test.nonghyub2024_high;

import java.util.Arrays;

public class ATMCombinations {
    // 연속된 ATM 금액의 합을 계산하는 메서드
    // 연속된 ATM 금액의 합을 계산하는 메서드
    private static int[] calculateContinuousSum(int money) {
        int[] dp = new int[money + 1];
        dp[0] = 1; // 초기값 설정

        // 1 2 3 4 5 6 (idx)
        // 0 0 0 0 0 0 (해당 돈이 가능한 경우의 수)
        for (int i = 1; i <= 10 && i <= money; i++) { // ATM에는 1만원부터 10만원까지만 넣을 수 있음
            for (int j = money; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));

        return dp;
    }

    // 나머지 ATM에 대한 금액의 합을 계산하는 메서드
    private static int countWays(int money, int[] continuousSum) {
        int count = 0;

        for (int i = 1; i <= money; i++) {
            count += continuousSum[i] * continuousSum[money - i];
        }

        return count;
    }

    // 주어진 조건에 따라 가능한 방법의 수를 반환하는 메서드
    public static int countATMCombinations(int money, int n, int t) {
        int[] continuousSum = calculateContinuousSum(money);
        int totalWays = countWays(money, continuousSum);

        // 연속된 ATM 금액의 합이 k 이하인 경우의 수를 반환
        return totalWays - countWays(money - t, continuousSum);
    }

    public static void main(String[] args) {
        // 예시 입력: 총 4만원을 보유하고 있을 때, 총 2대의 ATM 기기가 있으며, 연속된 1대의 ATM에 입금하는 금액의 합은 3만원 이하
        int result1 = countATMCombinations(4, 2, 1);
        System.out.println("Result 1: " + result1); // Result 1: 3

        // 예시 입력: 총 7만원을 보유하고 있을 때, 총 4대의 ATM의 개수 중 연속된 2대의 ATM에 입금하는 금액의 합은 4만원 이하
        int result2 = countATMCombinations(7, 4, 2);
        System.out.println("Result 2: " + result2); // Result 2: 28
    }
}
