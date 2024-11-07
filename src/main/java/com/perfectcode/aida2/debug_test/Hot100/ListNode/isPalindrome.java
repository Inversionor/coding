package com.perfectcode.aida2.debug_test.Hot100.ListNode;

import java.util.*;

/**
 * @Author: lzj
 * @Date: 2024/10/19 10:01
 */

/**
 * 回文链表
 * 思路：翻转链表，然后比较
 * 关键api：Collections.reverse()；list.equals(list2)
 */
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode cur= head;
        List<Integer> list = new ArrayList<>();
        while (cur != null ){
            list.add(cur.val);
            cur=cur.next;
        }
        List<Integer> list2 = new ArrayList<>(list);
        Collections.reverse(list);
        return list.equals(list2);
    }




}
