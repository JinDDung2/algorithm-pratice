package leetcode;

// 1283. Find the Smallest Divisor Given a Threshold
public class FindSmallestDivisorGivenThreshold_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) Math.pow(10, 6);

        while (left < right) {
            int mid = (left + right) / 2;
            int sumOfDivide = 0;

            for (int num : nums) {
                sumOfDivide += num / mid;
                sumOfDivide += (num % mid != 0 ? 1 : 0);
            }

            if (sumOfDivide <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
