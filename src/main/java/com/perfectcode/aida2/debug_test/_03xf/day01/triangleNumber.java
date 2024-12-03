package com.perfectcode.aida2.debug_test._03xf.day01;

import java.util.Arrays;

/**
 * 611.有效的三角形数
 * 记住双向双指针是用来求两数之和问题，所以这里枚举大的边，这样你就是在求两个小的边是否大于大的边问题。
 * 你枚举小的边就不是两数之和了，这时，你的双指针指向的数的两数之和必然满足大于小边
 * ，你反而要做的是nums[right] - nums[left] <nums[i]了，这样根本滑不动。
 */

public class triangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            int start = 0;
            int end = i-1;
            while (start < end){
                if (nums[end]+nums[start] > nums[i]){
                    res += end-start;
                    end--;
                }else {
                    start++;
                }
            }
        }
        return res;

    }
    public static void main(String[] args)
    {
        triangleNumber solution = new triangleNumber();
        int[] nums = {2,2,3,4};
        System.out.println(solution.triangleNumber(nums));
    }
}
