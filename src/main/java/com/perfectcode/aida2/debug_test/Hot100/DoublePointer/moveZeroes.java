package com.perfectcode.aida2.debug_test.Hot100.DoublePointer;

/**
 * @Author: lzj
 * @Date: 2024/10/14 17:22
 */

/**
 * 移动零
 * 思路：快慢指针，快指针遇到非0就赋值给慢指针，慢指针移动，直到快指针遍历完
 * 关键api: nums[slow] = nums[fast];
 */
public class moveZeroes {
    public void moveZeroes(int[] nums)
    {
        int slow = 0;
        int len=nums.length;
        for(int fast = 0;fast<len;fast++){
            if(nums[fast]!=0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < len; i++){
            nums[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes moveZeroes=new moveZeroes();
        moveZeroes.moveZeroes(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }

}
