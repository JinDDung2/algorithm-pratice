package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Max_Number_of_K_Sum_Pairs_1679 {

    // map에 차액을 담을 것
    // 1. map.get(차액) 존재하면 result ++
    // 1-1. map.get(차액)의 value가 1이면 해당 key 제거
    // 1-2. value > 1 이면 value -= 1
    // 2. map.get(차액) 존재하지 않으면 map.put(해당 숫자, map.getOrDefault(해당 숫자, 0) + 1)
    // 시간복잡도: O(N)
    // 공간복잡도: N
    public int maxOperationsV2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = k - nums[i];
            if (map.containsKey(num)) {
                result++;
                if (map.get(num) == 1) map.remove(num);
                else map.put(num, map.get(num) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return result;
    }

    // 정렬한 후 투포인터 사용
    // 시간복잡도: O(NlogN)
    // 공간복잡도: O(1)
    public int maxOperationsV1(int[] nums, int k) {
        int l = 0, r = nums.length - 1, result = 0;
        Arrays.sort(nums);
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                result++;
                l++;
                r--;
                continue;
            }

            if (nums[l] + nums[r] > k) {
                r--;
            } else {
                l++;
            }
        }

        return result;
    }
}
