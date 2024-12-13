package com.perfectcode.aida2.debug_test._03xf.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * LCR17 最小覆盖子串
 */

public class minWindow {
    public String minWindow(String s, String t) {
        char[] S = s.toCharArray();
        int m = s.length();
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[S[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[S[left]]--; // 左端点字母移出子串
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
