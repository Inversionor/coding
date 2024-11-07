package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 9:55
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }
}
