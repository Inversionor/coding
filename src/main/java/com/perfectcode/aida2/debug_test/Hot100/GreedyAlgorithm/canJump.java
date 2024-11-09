package com.perfectcode.aida2.debug_test.Hot100.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳跃游戏
 * 思路：我们在遍历数组的同时，维护最右可以到达的位置 mx
 */
public class canJump {
    public boolean canJump(int[] nums) {
        int mx =0;
        for (int i = 0; i < nums.length; i++) {
            if (i>mx){
                return false;
            }
            mx=Math.max(nums[i]+i,mx);
        }
        return true;
    }

}
