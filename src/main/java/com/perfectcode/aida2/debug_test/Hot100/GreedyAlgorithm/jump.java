package com.perfectcode.aida2.debug_test.Hot100.GreedyAlgorithm;


/**
 * 跳跃游戏Ⅱ
 *思路：局部极端化思想
 */
public class jump {
    public int jump(int[] nums) {
        int ans =0;
        int curRight=0;
        int nextRight=0;
        //判断len-1即可，因为如果curRight==len-1,题目也会保证能到达，那就ans+1即可
        //如果curRight<len-1,说明前面的桥梁已经可以够到达终点了
        for (int i = 0; i < nums.length-1; i++) {
            nextRight = Math.max(nextRight,i+nums[i]);
            if (i==curRight){
                curRight = nextRight;
                ans++;
            }
        }
        return ans;
    }

}
