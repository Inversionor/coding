package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 10:11
 */

/**
 * 环形链表
 * 思路:快慢指针
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
