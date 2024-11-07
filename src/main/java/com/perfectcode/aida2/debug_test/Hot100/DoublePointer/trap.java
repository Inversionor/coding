package com.perfectcode.aida2.debug_test.Hot100.DoublePointer;

/**
 * @Author: lzj
 * @Date: 2024/10/15 20:42
 */

/**
 * 接雨水
 * 思路：新建数组作为前缀和后缀的最大值的存储，一个槽的能存储的雨水由前缀和后缀的最大值减去当前高度，
 *
 */
public class trap {
    public int trap(int[] height) {
        int len = height.length;
        int[] preMax = new int[len];
        int[] postMax = new int[len];
        postMax[len-1] = height[len-1];
        preMax[0] = height[0];
        int res=0;
        for (int i = 1; i < len; i++){
            preMax[i] = Math.max(preMax[i-1],height[i-1]);
        }
        for (int i = len-2; i >= 0; i--){
            postMax[i] = Math.max(postMax[i+1],height[i+1]);
        }
        for (int i = 1; i < len-1; i++){
            int min = Math.min(preMax[i],postMax[i]);
            if (min>height[i]){
                res+=min-height[i];
            }
        }

        return res;

    }
    public static void main(String[] args) {
        trap t = new trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));
    }
}
