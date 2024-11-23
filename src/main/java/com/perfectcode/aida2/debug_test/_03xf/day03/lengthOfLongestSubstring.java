package com.perfectcode.aida2.debug_test._03xf.day03;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //方法1
//        Map<Character, Integer> map = new HashMap<>();
//        int res =0;
//        int left = 0;
//        int right=0;
//        while(right<s.length()){
//            Character key = s.charAt(right);
//            if(map.containsKey(key)){
//                left = Math.max(map.get(key),left);
//            }
//            res = Math.max(res,right-left+1);
//            map.put(key,right+1);
//            right++;
//        }
//        return res;
        //方法2
        Map<Character, Integer> map = new HashMap<>();
        int res =0;
        int left=0;
        for (int i = 0; i < s.length(); i++){
            map.putIfAbsent(s.charAt(i),0);
        }
        for (int i = 0; i < s.length(); i++){
            Character key = s.charAt(i);
            map.put(key,map.get(key)+1);
            while(map.get(key)>1){
                Character left_key = s.charAt(left);
                map.put(left_key,map.get(left_key)-1);
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return  res;
    }
    public static void main(String[] args){
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }
}
