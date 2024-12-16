package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 83. 删除排序链表中的重复元素
 */

public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        deleteDuplicates deleteDuplicates = new deleteDuplicates();
        ListNode res = deleteDuplicates.deleteDuplicates(head);
        while (res != null) {}
    }
}
