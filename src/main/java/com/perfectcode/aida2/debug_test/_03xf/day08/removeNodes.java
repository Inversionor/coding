package com.perfectcode.aida2.debug_test._03xf.day08;

import java.util.Stack;

/**
 * 2487.从链表中移除节点
 */

public class removeNodes {
    public ListNode removeNodes(ListNode head) {
//        方法一：用棧
//        Stack<ListNode> stack = new Stack<>();
//        ListNode cur = head;
//        while (cur!=null){
//            while (!stack.isEmpty()&&stack.peek().val<cur.val){
//                stack.pop();
//            }
//            stack.push(cur);
//            cur = cur.next;
//        }
//        ListNode nxt =null;
//        while (!stack.isEmpty()){
//            cur = stack.pop();
//            cur.next = nxt;
//            nxt = cur;
//        }
//        return cur;


//        方法二：反转链表后删除比当前节点值小的节点，如果遇到大的，那就指针往前走
//        head = reverseList(head);
//        ListNode cur = head;
//        while (cur.next != null) {
//            if (cur.val > cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return reverseList(head);
//    }
//
//    private ListNode reverseList(ListNode head) {
//        ListNode pre = null, cur = head;
//        while (cur != null) {
//            ListNode nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//        return pre;
//    }

//        方法三：递归：既然要倒着看最大值，那么用递归解决是最合适的，毕竟递归本质就是在倒着遍历链表。
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next); // 返回的链表头一定是最大的
        if (node.val > head.val) {
            return node; // 删除 head
        }
        head.next = node; // 不删除 head
        return head;




    }
}
