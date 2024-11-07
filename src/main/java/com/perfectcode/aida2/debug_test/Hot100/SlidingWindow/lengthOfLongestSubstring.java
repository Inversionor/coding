package com.perfectcode.aida2.debug_test.Hot100.SlidingWindow;

/**
 * @Author: lzj
 * @Date: 2024/10/15 21:48
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 思路：滑动窗口，使用map记录当前窗口内字符出现的位置，
 * 如果当前字符已经出现过，则将窗口左边界移动到当前字符出现的位置的下一个位置，
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res =0;
        int j =-1;
        int tmp=0;
        for (int i = 0; i < s.length(); i++){
            Character key = s.charAt(i);
            if(map.containsKey(key)){
                //用max十为了保证指针不会回到之前已经出现过的位置，比如abba，当i=3时，j=1，但是map.get(key)=0，所以j=0
                j =Math.max(map.get(key),j) ;
            }
            tmp = i-j;
            res = Math.max(res,tmp);
            map.put(key,i);

        }
        return res;

    }
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
