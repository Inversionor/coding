package com.perfectcode.aida2.debug_test.Hot100.SlidingWindow;

/**
 * @Author: lzj
 * @Date: 2024/10/15 23:47
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 思路：滑动窗口，用两个数组记录p和s的字符出现的次数，然后比较两个数组是否相等，如果相等，则加入res。
 * 同时移动窗口，如果移动后的s和p的字符出现次数相等，则加入res。
 * 关键api：Arrays.equals(p_count,s_count)这个函数，判断两个数组是否相等
 */
public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] p_count = new int[26];
        int[] s_count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            p_count[p.charAt(i) - 'a']++;
            s_count[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(p_count,s_count)){
            res.add(0);
        }
        for (int i=1;i<s.length()-p.length()+1;i++){
            s_count[s.charAt(i-1)-'a']--;
            s_count[s.charAt(i+p.length()-1)-'a']++;
            if(Arrays.equals(p_count,s_count)){
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        System.out.println(new findAnagrams().findAnagrams(s,p));
    }
}
