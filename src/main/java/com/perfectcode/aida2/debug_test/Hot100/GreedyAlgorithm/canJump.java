package com.perfectcode.aida2.debug_test.Hot100.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳跃游戏
 * s
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
