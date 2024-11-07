package com.perfectcode.aida2.debug_test.Hot100.Substring;

/**
 * @Author: lzj
 * @Date: 2024/10/17 21:59
 */

import java.util.HashMap;

/**
 * 最小覆盖子串
 * 如何保存窗口内字符的频次？用哈希表，key为字符，value为频次
 * 如何进行比较？写一个cover字符，比较目标子串的key是否在窗口内，并且频次是否满足目标子串
 * 如何保存目标子串？通过一个ansleft指针和ansright指针保存，当right-left<ansright-ansleft的时候，更新ansleft和ansright，
 * 然后使用substring方法返回结果
 */
public class minWindow {
    public String minWindow(String s, String t) {
        int len_t=t.length();
        int len_s=s.length();
        HashMap<Character,Integer> map_t=new HashMap<>();
        for(int i=0;i<len_t;i++){
            char str=t.charAt(i);
            map_t.put(str,map_t.getOrDefault(str,0)+1);
        }
        int left=0;
        int ansleft=-1;
        int ansright=len_s;
        HashMap<Character,Integer> map_s=new HashMap<>();
        for (int right=0;right<len_s;right++){
            char str=s.charAt(right);
            map_s.put(str,map_s.getOrDefault(str,0)+1);
            while(isCovered(map_t,map_s)){
                if(right-left<ansright-ansleft){
                    ansleft=left;
                    ansright=right;
                }
                char left_str=s.charAt(left);
                map_s.put(left_str,map_s.get(left_str)-1);
                left++;
            }
        }
        //当你想要包括 ansright 位置的字符时，必须传递 ansright + 1
        return ansleft<0? "" : s.substring(ansleft,ansright+1);
    }
    public boolean isCovered(HashMap<Character,Integer> map_t,HashMap<Character,Integer> map_s){
        for(Character key:map_t.keySet()){
            //防止null 值
            if(map_s.getOrDefault(key,0)<map_t.get(key)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow test=new minWindow();
        System.out.println(test.minWindow(s,t));
    }
}
