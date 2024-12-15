package com.perfectcode.aida2.debug_test._03xf.day06;
import com.perfectcode.aida2.debug_test._03xf.day06.ListNode;

/**
 * 445.两数相加2
 */

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummyNode = new ListNode(-1); // 哑节点，用于构造结果链表
        ListNode cur = dummyNode;
        int carry = 0; // 进位标志

        // 遍历两个链表
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry; // 当前位的和
            carry = sum / 10; // 更新进位
            int rel_val = sum % 10; // 当前位的实际值

            cur.next = new ListNode(rel_val); // 创建新节点
            cur = cur.next;

            // 移动链表指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return reverseList(dummyNode.next);
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head; // 把下一个节点指向自己
        head.next = null; // 断开指向下一个节点的连接，保证最终链表的末尾节点的 next 是空节点
        return newHead;
    }
}
