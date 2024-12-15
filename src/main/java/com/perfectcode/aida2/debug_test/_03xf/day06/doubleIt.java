package com.perfectcode.aida2.debug_test._03xf.day06;

import lombok.val;

/**
 * 2816.翻倍以链表形式表示的数字
 */

public class doubleIt {
    public ListNode doubleIt(ListNode head) {
        head = reverList(head);
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode p0 = dummyNode;
        ListNode cur = dummyNode;
        while (head!=null||carry!=0){
            //如果head！=null，那么就是有值，否则就是0，简化了代码逻辑
            int val1 = (head!=null)?head.val:0;
            int sum = val1*2+carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            //如果不进行检查，那么carry！=0但是head==null的时候依然会进入循环，那么会造成空指针异常
            if (head!=null){
                head = head.next;
            }
        }
        return reverList(p0.next);
    }
    private ListNode reverList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummyNode = new ListNode(-1,head);
        ListNode p0 = dummyNode;
        ListNode pre =null;
        ListNode cur = head;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        p0.next = pre;
        return p0.next;
    }
}
