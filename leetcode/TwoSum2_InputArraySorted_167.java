package leetcode;

// 167. Two Sum II - Input Array Is Sorted
public class TwoSum2_InputArraySorted_167 {
    public int[] twoSumV2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }

        return new int[] { left + 1, right + 1 };
    }

    public int[] twoSumV1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return result;
    }
}
