package com.perfectcode.aida2.debug_test._03xf.day02;

/**
 * 接雨水
 */
public class maxArea {
    public int maxArea(int[] height) {
        int left =0;
        int right =height.length-1;
        int max =0;
        while(left<right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
