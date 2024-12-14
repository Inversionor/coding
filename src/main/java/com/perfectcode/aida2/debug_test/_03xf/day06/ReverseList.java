package com.perfectcode.aida2.debug_test._03xf.day06;

import com.perfectcode.aida2.debug_test.Hot100.ListNode.ListNode;

/**
 * 206. 反转链表
 * 静态内部类
 */
public class ReverseList {
    // 定义静态内部类
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 反转链表方法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    // 主方法
    public static void main(String[] args) {
        // 创建链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 调用反转链表方法
        ListNode res = new ReverseList().reverseList(head);

        // 打印反转后的链表
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

