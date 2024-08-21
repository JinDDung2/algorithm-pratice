package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Maximum_Twin_Sum_of_a_Linked_List_2130 {

    public int pairSum(ListNode head) {
        // 절반까지만 맨 마지막
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int result = 0;
        while (prev != null) {
            result = Math.max(result, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return result;
    }

}
