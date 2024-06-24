package f_lab.toss;

import java.util.Arrays;

public class Test {

    public int solution1(int[] levels) {
        int n = levels.length;

        if (n < 4) {
            return -1;
        }
        int limit = (int) (n + 1) * 3 / 4;
        Arrays.sort(levels);

        System.out.println(Arrays.toString(levels));
        int answer = levels[limit];
        return answer;
    }

    public int solution2(String s) {
        int answer = -1;

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                answer = Math.max(answer, Integer.parseInt(s.substring(i, i + 3)));
            }
        }

        return answer;
    }

    public boolean solution3(String amountText) { // 케이스 13 실패
        // 5
        if (amountText.startsWith(",") || amountText.endsWith(",")) {
            return false;
        }

        // 1
        String numericPart = amountText.replace(",", "");
        if (!numericPart.matches("\\d+")) {
            return false;
        }

        // 2
        if (numericPart.length() > 1 && numericPart.startsWith("0")) {
            return false;
        }

        if (numericPart.equals("0")) {
            return true;
        }

        if (amountText.contains(",")) {

            String[] parts = amountText.split(",");

            for (int i = 1; i < parts.length; i++) {
                if (parts[i].length() != 3) {
                    return false;
                }
            }
        }

        return true;
    }

    // 부가가치세: 과세 * 0.1 -> 소수점 첫째자리에서 올림
    // 과세금액: 공급가액 - 비과세(부가가치세가 부과되지 않은 금액)
    // 공급대가(=주문금액): 공급가액 + 부가가치세
    // 봉사료 존재? -> 공급대가: 주문금액 - 봉사료
    // 공급대가 - 비과세 = 1? 부가가치세 0원
    public long solution5(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        // 공급대가
        long supplyAmount = orderAmount - serviceFee;
        // 과세
        long taxAmount = supplyAmount - taxFreeAmount;
        // 부가세
        double preciseVat = taxAmount * 0.1;
        long vat = (long) Math.round(preciseVat);
        // 부가세 예외처리
        if (supplyAmount - taxFreeAmount == 1) {
            vat = 0;
        }
        return vat;
    }

    public long solution6(int money, long[][] stocks) {
        long[] dp = new long[money + 1];

        for (int i = 0; i < stocks.length; i++) {
            long value = stocks[i][0];
            int price = (int) stocks[i][1];

            for (int j = money; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + value);
            }
        }

        return dp[money];
    }

    public static void main(String[] args) {
    }
}
