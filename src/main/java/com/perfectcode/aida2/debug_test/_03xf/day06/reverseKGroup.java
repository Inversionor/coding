package com.perfectcode.aida2.debug_test._03xf.day06;

/**
 * 25. K 个一组翻转链表
 */

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Count the total number of nodes
        ListNode count = head;
        int num = 0;
        while (count != null) {  // Fix: Use 'count' here instead of 'head'
            count = count.next;
            num++;
        }

        // Calculate the number of k-groups to process
        int time = num / k;

        // Dummy node to simplify head processing
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;

        for (int i = 0; i < time; i++) {
            ListNode pre = null;
            ListNode cur = p0.next;

            // Reverse k nodes
            for (int j = 0; j < k; j++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            // Reconnect reversed segment with the rest of the list
            ListNode nxt = p0.next;  // `nxt` is the original head of the current segment
            p0.next.next = cur;      // Fix: Ensure `p0.next` exists before accessing `p0.next.next`
            p0.next = pre;           // `pre` is the new head after reversing
            p0 = nxt;                // Move `p0` to the end of the reversed segment
        }

        return dummy.next;
    }
}
