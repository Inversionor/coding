package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

public class successfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int spell = spells[i];
            //向上取整，并且使用long保住了精度
            long target = ((success + spell - 1) / spell);
            int index = lower_bound(potions, target);
            res[i] = potions.length-index;
        }
        return res;


    }
    public int lower_bound(int [] nums, long target){
        int left = -1;
        int right = nums.length;
        while(left+1<right){
            int mid =left+(right-left)/2;
            if(nums[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }


}
