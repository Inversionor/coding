package com.perfectcode.aida2.debug_test._03xf.day08;

/**
 * 1669. 合并两个链表
 */
public class mergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left  = list1;
        ListNode right = list1;
        for (int i = 0; i < a-1; i++) {
            left = left.next;
        }
        for (int i = 0; i < b+1; i++) {
            right = right.next;
        }
        left.next=list2;
        while (list2.next!=null){
            list2=list2.next;
        }
        list2.next=right;
        return list1;

    }
}
