package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 10:19
 */

/**
 * 环形链表2
 * 思路：第一次先判断是否存在环形链表，第二次通过快慢指针判断环形链表的入口点
 */
public class hasCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow =head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        if(fast==null||fast.next==null) return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
