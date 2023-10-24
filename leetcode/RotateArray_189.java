package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 189. Rotate Array
public class RotateArray_189 {

    public void rotateV2(int[] nums, int k) {
        k %= nums.length;
        // 배열 전부 뒤집기
        reverse(nums, 0, nums.length - 1);
        // 0 ~ k-1 뒤집기
        reverse(nums, 0, k - 1);
        // k ~ last idx 뒤집기
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateV1(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            deque.addLast(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int num = deque.pollLast();
            deque.addFirst(num);
        }

        // System.out.println(deque);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.pollFirst();
        }
    }
}
