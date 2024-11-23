package com.perfectcode.aida2.debug_test._03xf.day02;

/**
 * 接雨水
 * 相向双指针
 */
public class trap {
    public int trap(int[] height) {
        int len = height.length;
        int[] preMax = new int[len];
        int[] postMax = new int[len];
        preMax[0] = height[0];
        postMax[len-1] = height[len-1];
        for (int i = 1; i < len; i++){
            preMax[i] = Math.max(height[i],preMax[i-1]);
        }
        for (int i = len-2; i >= 0; i--){
            postMax[i] = Math.max(height[i],postMax[i+1]);
        }
        int res = 0;
        for (int i = 1; i < len-1; i++){
            int min = Math.min(preMax[i],postMax[i]);
            if (min>height[i]){
                res+=min-height[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap t = new trap();
        System.out.println(t.trap(height));
    }
}
