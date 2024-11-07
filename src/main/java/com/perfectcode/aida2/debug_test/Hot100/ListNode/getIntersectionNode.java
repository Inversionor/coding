package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 9:46
 */

/**
 *相交链表
 * 思路：p和q同时遍历，如果p和q不相等，则p和q指向链表头，再次遍历，如果p和q相等，则p和q指向相交节点，否则p和q指向null
 * 关键代码：p = p == null ? headB : p.next;
 */
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        getIntersectionNode getIntersectionNode = new getIntersectionNode();
        System.out.println(getIntersectionNode.getIntersectionNode(node1,node2).val);
    }
}
