package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 237. 删除链表中的节点
 */
public class deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;

    }
}
