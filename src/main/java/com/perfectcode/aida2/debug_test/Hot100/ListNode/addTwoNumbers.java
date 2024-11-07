package com.perfectcode.aida2.debug_test.Hot100.ListNode;

/**
 * @Author: lzj
 * @Date: 2024/10/19 10:31
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 两数相加
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode cur = l1;
        while (cur != null) {
            list1.add(cur.val);
            cur = cur.next;
        }
        cur= l2;
        while (cur!= null) {
            list2.add(cur.val);
            cur = cur.next;
        }
        List<Integer> list3 = new ArrayList<>();
        int len3 = list1.size() < list2.size() ? list1.size() : list2.size();
        for (int i = 0; i < len3; i++) {
            list3.add(list1.get(i) + list2.get(i));
        }
        int len4 = list1.size() > list2.size() ? list1.size() : list2.size();
        for (int i = len3; i < len4; i++) {
            if (i < list1.size()) {
                list3.add(list1.get(i)); // 只在 list1 有值时添加
            } else {
                list3.add(list2.get(i)); // 否则从 list2 添加
            }
        }
        int len= list3.size();
        for (int i = 0; i < len-1; i++){
            if (list3.get(i)>=10){
                list3.set(i,list3.get(i)-10);
                list3.set(i+1,list3.get(i+1)+1);
            }
        }
        if (list3.get(len-1)>=10){
            list3.set(len-1,list3.get(len-1)-10);
            list3.add(1);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur2 = dummy;
        for (int i = 0; i < list3.size(); i++) {
            cur2.next = new ListNode(list3.get(i));
            cur2 = cur2.next;
        }
        return dummy.next;
    }
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        addTwoNumbers addTwoNumbers = new addTwoNumbers();
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1,l2);
    }
}
