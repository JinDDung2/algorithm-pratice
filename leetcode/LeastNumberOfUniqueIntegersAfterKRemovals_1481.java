package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 1481. Least Number of Unique Integers after K Removals
public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // k개 삭제 후 유니크한 숫자 개수가 최소화
        // 같은 숫자가 적은 숫자부터 제거.
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        int result = pq.size();
        while(k > 0 && !pq.isEmpty()) {
            int count = pq.poll();
            if (k >= count) {
                k -= count;
                result--;
            } else {
                break;
            }
        }

        return result;
    }
}
