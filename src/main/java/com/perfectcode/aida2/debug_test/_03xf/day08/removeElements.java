package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 203. 移除链表元素
 */

public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur =dummy;
        //不等于null，就保证了cur.next.next保底是null
        while(cur.next!=null){
            if (cur.next.val==val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}
