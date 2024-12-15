package com.perfectcode.aida2.debug_test._03xf.day07;

/**
 * 2130.链表最大孪生和
 */

public class pairSum {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        int ans = 0;
        while(right!=null){
            ans = Math.max(ans,left.val+right.val);
            left=left.next;
            right = right.next;
        }
        return ans;


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
        ListNode head = new ListNode(1,new ListNode(10000,null));
        pairSum solution = new pairSum();
        int ans = solution.pairSum(head);
        System.out.println(ans);
    }
}
