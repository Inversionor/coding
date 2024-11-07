package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 15:14
 */

/**
 * K个一组翻转链表
 * 思路：创建哑节点，创建pre=null，cur=head，p0=dummy；循环，把上个循环的尾节点当作下一个循环的哑节点
 * 循环结束后，返回dummy.next
 * 两个for循环，第一个循环，计算链表的长度，第二个循环，翻转链表，并把翻转后的链表连接到下一个循环的哑节点上。
 */
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;
        for (;n>=k;n-=k){
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ListNode temp = p0.next;
            p0.next = pre;
            temp.next = cur;
            p0 = temp;
        }
        return dummy.next;
    }

}
