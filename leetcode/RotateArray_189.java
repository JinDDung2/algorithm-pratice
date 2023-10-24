package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 189. Rotate Array
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
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
