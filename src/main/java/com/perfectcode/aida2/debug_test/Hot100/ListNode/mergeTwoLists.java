package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 10:23
 */

/**
 * 合并两个有序链表
 * 思路：构造一个虚拟头结点，遍历两个链表，比较两个链表当前节点的值，将较小的节点加入到虚拟头结点后面，直到两个链表都遍历完。最后将剩余的链表加入到虚拟头结点后面。
 * 关键代码：while循环进行比较两个链表的节点值；cur.next = index1 != null ? index1 : index2;
 */
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode index1 = list1, index2 = list2;
        while(index1 != null && index2 != null){
            if(index1.val<index2.val){
                cur.next = index1;
                index1 = index1.next;
            }else{
                cur.next = index2;
                index2 = index2.next;
            }
            cur = cur.next;
        }
        cur.next = index1 != null ? index1 : index2;
        return dummy.next;
    }
}
