package leetcode;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        // l=0, r=nums.length-1
        int l = 0, r = nums.length - 1;
        // l <= r 반복
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target)
                return mid;
            // 오름차순
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
