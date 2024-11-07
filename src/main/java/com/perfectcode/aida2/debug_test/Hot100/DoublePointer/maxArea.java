package com.perfectcode.aida2.debug_test.Hot100.DoublePointer;

/**
 * @Author: lzj
 * @Date: 2024/10/14 22:33
 */

/**
 * 盛最多水的容器
 * 思路：若向内移动短板，下个水槽的面积，可能增大 。
 *      若向内移动长板，下个水槽的面积，一定变小。
 *      因此，每次移动短板，求出最大面积，并更新最大面积。
 * 关键api: Math.min(height[left],height[right])
 */
public class maxArea {
    public int maxArea(int[] height) {
        int len =height.length;
        int left=0;
        int right =len-1;
        int max=0;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            max=Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        maxArea maxArea=new maxArea();
        int i = maxArea.maxArea(height);
        System.out.println(i);
    }
}
