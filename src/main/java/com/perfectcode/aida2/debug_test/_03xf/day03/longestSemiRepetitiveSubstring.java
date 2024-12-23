package com.perfectcode.aida2.debug_test._03xf.day03;


/**
 * 2730.找到最长的半重复字符串
 */

public class longestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] S = s.toCharArray();
        int ans = 1, left = 0, same = 0, n =S.length;
        for (int right = 1; right < n; right++) {
            if (S[right] == S[right - 1] && ++same > 1) {
                for (left++; S[left] != S[left - 1]; left++);
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
