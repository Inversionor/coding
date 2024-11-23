package com.perfectcode.aida2.debug_test.lc_daily;


/**
 * 统计不是特殊数字的数字数量
 * 特殊数字：只有两个因数（除了自身）
 * 质数一定不是特殊数字
 * 只有质数的平方才是特殊数字，恰好有俩真因数
 */
public class lc3233 {
    public int nonSpecialCount(int l, int r) {
        int len = r - l + 1;
        return len - (int) Math.sqrt(r) + 1;


    }
}
