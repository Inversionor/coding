package com.perfectcode.aida2.debug_test._03xf.day07;

/**
 * 143. 重排链表
 * 截断，反转，合并
 */

public class reorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head,slow =head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        right = reverse(right);
        ListNode left = head;
        while(right!=null){
            ListNode nxt_right = right.next;
            ListNode nxt_left = left.next;
            left.next = right;
            right.next = nxt_left;
            right = nxt_right;
            left = nxt_left;

        }
    }
    private ListNode reverse(ListNode head){
        ListNode dummyNode = new ListNode(-1,head);
        ListNode pre =null;
        ListNode cur = head;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        dummyNode.next = pre;
        return dummyNode.next;
    }
}
