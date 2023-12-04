package leetcode;

import java.util.Arrays;

// 274. H-Index
public class HIndex_274 {
    // O(N) 0ms
    public int hIndexV2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int num : citations) {
            if (num >= n) {
                buckets[n]++;
            } else {
                buckets[num]++;
            }
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += buckets[i];
            if (cnt >= i) {
                return i;
            }
        }

        return -1;
    }

    // NlogN | 2ms
    public int hIndexV1(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, rst = 0;

        for (int i = 0; i < n - rst; i++) {
            if (citations[i] != rst) {
                rst = Math.max(rst, Math.min(citations[i], n - i));
            }
        }

        return rst;
    }
}
