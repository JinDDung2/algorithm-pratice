package leetcode;

import java.util.Arrays;

// 238. Product of Array Except Self
public class ProductArrayExceptSelf_238 {
    // 3ms
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int curr = 1;
        // 특정 인덱스의 왼쪽에 있는 값들을 모두 곱하기 (배열 안쓰고)
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        // 특정 인덱스의 오른쪽에 있는 값들을 모두 곱하기 (배열 안쓰고)
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }

    // 2ms
    public int[] productExceptSelfV1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int allMultipleNum = 1;
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                allMultipleNum *= nums[i];
            } else {
                countZero++;
            }
        }

        if (countZero > 1) {
            return new int[n];
        }

        for (int i = 0; i < n; i++) {
            if (countZero == 1) {
                ans[i] = nums[i] == 0 ? allMultipleNum : 0;
            }

            if (countZero == 0) {
                ans[i] = allMultipleNum / nums[i];
            }
        }

        return ans;
    }
}
