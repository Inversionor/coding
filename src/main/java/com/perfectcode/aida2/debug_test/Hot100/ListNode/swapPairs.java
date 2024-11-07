package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 14:51
 */

/**
 * 两两交换链表中的节点
 * 思路：递归，每一个子模块都由一个哑节点和一个头节点和一个未节点，还有下一个模块的头节点。
 * 指针指向哑节点，头节点还有下一个模块的头节点
 * 递归终止条件是链表为空或者只有一个节点
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0,head);
        ListNode cur =dummyHead;
        ListNode index1=cur.next;
        ListNode index2=cur.next.next.next;
        cur.next=index1.next;
        cur.next.next=index1;
        index1.next=swapPairs(index2);
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        swapPairs swapPairs=new swapPairs();
        swapPairs.swapPairs(node1);
        while(node2!=null){
            System.out.println(node2.val);
            node2=node2.next;
        }

    }
}
