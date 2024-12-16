package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 删除头节点适合创建一个dummynode
 */

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);
        ListNode right = dummy;
        ListNode left = dummy;
        for(int i =0 ; i< n ;i++){
            right = right.next;
        }
        while(right.next!=null){
            left=left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

}
