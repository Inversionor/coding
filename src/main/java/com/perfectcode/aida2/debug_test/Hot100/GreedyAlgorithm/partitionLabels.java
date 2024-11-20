package com.perfectcode.aida2.debug_test.Hot100.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母
 * 思路：记录每个字母最后出现的位置，本质上是合并区间，如果当前字符是end，那么说明当前字符串已经遍历完了，可以分割了
 */

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();
        int n =s.length;
        int[] last = new int[26];
        // 记录每个字母最后出现的位置
        for (int i = 0; i < n; i++) {
            last[s[i]-'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s[i]-'a']);
            //如果说当前的字符是end，那么说明当前字符串已经遍历完了，可以分割了
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
