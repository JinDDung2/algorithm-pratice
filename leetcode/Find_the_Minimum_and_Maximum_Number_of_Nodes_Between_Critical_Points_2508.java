package leetcode;

import java.util.*;

public class Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_2508 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int age = head.val;
        ListNode node = head.next;
        int idx = 1;

        while (node.next != null) {
            int curr = node.val;
            int next = node.next.val;
            // maxima
            if (age < curr && curr > next) list.add(idx);
            // minima
            if (age > curr && curr < next) list.add(idx);
            age = node.val;
            node = node.next;
            idx++;
        }

        if (list.size() >= 2) {
            int len = list.size();
            int max = list.get(len - 1) - list.get(0);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < len; i++) {
                min = Math.min(min, list.get(i) - list.get(i - 1));
            }

            return new int[]{min, max};
        }

        return new int[]{-1, -1};
    }

    /*class ListNode {
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
    }*/
}
