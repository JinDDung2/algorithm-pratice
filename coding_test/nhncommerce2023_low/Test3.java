package coding_test.nhncommerce2023_low;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] arr = { 1, 10, 5, 4, 5, 2, 8, 3, 15 };
        int k = 3;
        test3.solution(arr, k);
    }

    public int[] solution(int[] appetites, int k) {
        int[] answer = new int[appetites.length];
        int[] copy = Arrays.copyOf(appetites, appetites.length);
        Arrays.sort(copy);

        for (int i = 0; i < appetites.length; i++) {
            int left = lowerBound(i, copy, k);
            int right = upperBound(i, copy, k);
            int cnt = right - left;
            System.out.printf("i=%d, left=%d, right=%d\n", i, left, right);
            answer[i] = cnt;
        }

        return answer;
    }

    private int lowerBound(int i, int[] copy, int k) {
        int min = copy[i] - k > 0 ? copy[i] - k : 0;
        int start = copy[0];
        int end = copy[copy.length - 1];

        while (start < end) {
            int mid = (start + end) / 2;

            if (mid >= min)
                end = mid;
            else
                start = mid + 1;
        }

        int leftIdx = 0;
        while (copy[leftIdx] <= start) {
            if (leftIdx >= copy.length)
                break;
            leftIdx++;
        }

        return leftIdx;
    }

    private int upperBound(int i, int[] copy, int k) {
        int max = copy[i] + k > 2_000_000_000 ? 2_000_000_000 : copy[i];
        int start = copy[0];
        int end = copy[copy.length - 1];

        while (start < end) {
            int mid = (start + end) / 2;

            if (mid > max)
                end = mid;
            else
                start = mid + 1;
        }

        int rightIdx = copy.length - 1;
        while (copy[rightIdx] >= start) {
            if (rightIdx <= 0)
                break;
            rightIdx--;
        }
        System.out.printf("rightIdx=%d, start=%d | ", rightIdx, start);
        return rightIdx;
    }
}
