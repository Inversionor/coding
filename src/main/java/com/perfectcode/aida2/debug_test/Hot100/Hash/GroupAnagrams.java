package com.perfectcode.aida2.debug_test.Hot100.Hash;

import java.util.*;

/**
 * @Author: lzj
 * @Date: 2024/10/14 1:16
 */

/**
 * 字母异位词分组
 * 用哈希表来分组，把排序后的字符串当作 key，原字符串组成的列表（即答案）当作 value。
 * 关键api 就是 Arrays.sort(chars)；toCharArray()；String.valueOf(chars)；
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
            list.add(str);
            map.put(String.valueOf(chars), list);
         }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }
}
