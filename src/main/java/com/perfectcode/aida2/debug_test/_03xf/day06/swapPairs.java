package com.perfectcode.aida2.debug_test._03xf.day06;
import com.perfectcode.aida2.debug_test._03xf.day06.ListNode;

/**
 * 24. 两两交换链表中的节点
 */

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null){
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2;
            node2.next = node1;
            node1.next = node3;

            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
    }
}
