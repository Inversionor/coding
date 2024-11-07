package com.perfectcode.aida2.debug_test.LeetCode;

/**
 * @Author: lzj
 * @Date: 2024/10/18 18:17
 */

/**
 * 比较版本号
 * 思路：分割字符串，然后比较
 * 关键api: split()：分割字符串，默认以空格分割。Integer.parseInt()：将字符串转换为整数。（"001"转为1）
 */
public class LC165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = v1.length;
        int m = v2.length;
        int i = 0, j = 0;

        while (i < n || j < m) {
            int a = 0, b = 0;
            if (i < n) a = Integer.parseInt(v1[i++]);
            if (j < m) b = Integer.parseInt(v2[j++]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        LC165 lc165 = new LC165();
        System.out.println(lc165.compareVersion("1.0", "1.0.0"));
    }
}
