package com.perfectcode.aida2.debug_test._03xf.day07;

import com.perfectcode.aida2.debug_test._03xf.day07.ListNode;

/**
 * 141.环形链表
 * 用相对速度思考一下
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow =head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;

    }
}
