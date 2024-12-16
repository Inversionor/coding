package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 82. 删除排序链表中的重复元素 II
 */

public class deleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode dummy = new ListNode(-101,head);
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
            }
            else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;


    }
}
