package leetcode;

public class Product_of_Array_Except_Self_238 {
    public int[] productExceptSelf(int[] nums) {
        // 곱셈 저장
        int n = nums.length;
        int zeros = 0, mul = 1;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                continue;
            }
            mul *= num;
        }

        // zeros > 1 -> 전부 0
        // zeros = 1 -> 0인값은 곱셈, 나머지는 0
        // zeros < 0 -> 곱셈 / 해당 값
        for (int i = 0; i < n; i++) {
            if (zeros > 1) {
                nums[i] = 0;
            } else if (zeros == 1) {
                nums[i] = nums[i] == 0 ? mul : 0;
            } else {
                nums[i] = mul / nums[i];
            }
        }

        return nums;
    }
}
