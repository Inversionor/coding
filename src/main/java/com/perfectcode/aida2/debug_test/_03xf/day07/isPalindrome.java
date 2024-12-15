package com.perfectcode.aida2.debug_test._03xf.day07;

/**
 * 234. 回文链表
 */

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while(right!=null){
            if(left.val != right.val){
                return false;
            }
            left=left.next;
            right = right.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode dummyNode = new ListNode(-1,head);
        ListNode pre =null;
        ListNode cur = head;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        dummyNode.next = pre;
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println(new isPalindrome().isPalindrome(head));
    }

}
