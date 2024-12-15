package com.perfectcode.aida2.debug_test._03xf.day07;

/**
 * 876.链表的中间结点
 * 两个指针指向链表的头节点，一个慢指针，一个快指针。
 * 快指针每次移动两步，慢指针每次移动一步，当快指针到达链表尾部时，慢指针恰好位于中间。
 * 长度为奇数的时候，快指针在最后一个节点，慢指针在中间结点
 * 长度为偶数的时候，快指针在最后一个节点的下一个空节点，慢指针在中间结点
 */

public class middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
    }
}
