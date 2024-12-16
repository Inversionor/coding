package com.perfectcode.aida2.debug_test._03xf.day08;

import java.util.HashSet;
import java.util.Set;

/**
 * 3217.从链表中移除在数组中存在的节点
 */
public class modifiedList {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (cur!=null&&cur.next!=null){
            while(cur.next!=null&&set.contains(cur.next.val)){
                cur.next = cur.next.next;
            };
            cur = cur.next;
        }
        return dummy.next;


    }
}
