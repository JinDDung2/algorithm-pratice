package leetcode;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode ln : lists) {
            if (ln != null) {
                pq.add(ln);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            if (node.next != null)
                pq.add(node.next);
            dummy = dummy.next;
        }

        return cur.next;
    }

}
