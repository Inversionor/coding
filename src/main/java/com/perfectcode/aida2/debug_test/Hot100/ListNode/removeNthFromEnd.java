package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 14:49
 */

/**
 * 删除链表倒数第n个节点
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length=0;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        // 虚拟头结点，避免删除头结点的情况
        ListNode dummyNode=new ListNode(0,head);
        ListNode pre=dummyNode;
        for(int i =0;i<length-n;i++){
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return dummyNode.next;
    }
}
