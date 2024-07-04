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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = head;
        ListNode node = head.next;
        int sum = 0;

        while (node != null) {
            if (node.val == 0) {
                result = result.next;
                result.val = sum;
                sum = 0;
            } else {
                sum += node.val;
            }
            node = node.next;
        }
        result.next = null;

        return head.next;
    }
}
