package com.perfectcode.aida2.debug_test._03xf.day07;

/**
 * 142. 环形链表 II
 */

public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow =head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                while(head!=slow){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            };
        }
        return null;


    }
}
