package leetcode;


// 3185. Count Pairs That Form a Complete Day II
public class CountPairsThatFormCompleteDayII_3185 {
    // 24로 나누어지는 수 -> n(n-1) / 2;
    // 12로 나누어지는 수 -> n(n-1) / 2;
    // 그 외는 h * (24-h)되면 카운트
    public long countCompleteDayPairs(int[] hours) {
        long[] nums = new long[24];
        for (int h : hours) {
            nums[h % 24]++;
        }

        long result = 0L;
        result += nums[0] * (nums[0] - 1) / 2;
        result += nums[12] * (nums[12] - 1) / 2;

        for (int i = 1; i < 12; i++) {
            result += nums[i] * nums[24 - i];
        }

        return result;
    }
}
