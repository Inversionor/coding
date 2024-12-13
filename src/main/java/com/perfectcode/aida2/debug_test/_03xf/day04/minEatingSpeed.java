package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

/**
 * 875.爱吃香蕉的珂珂
 */

public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        return lower_bound(piles,h);

    }
    public int lower_bound(int [] piles,int h){
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt()+1;
        while(left+1<right){
            int mid =left+(right-left)/2;
            if(!check(mid, piles, h)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    private boolean check(int mid, int[] piles, int h) {
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / mid;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }
}
