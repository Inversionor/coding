package com.perfectcode.aida2.debug_test.Hot100.Substring;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: lzj
 * @Date: 2024/10/16 16:54
 */

/**
 * 滑动窗口最大值
 * 思路：利用双端队列，将当前窗口内的元素与队列中元素比较，如果当前元素大于队列中元素，则将队列中元素弹出，直到当前元素小于等于队列中元素，保持队列中元素单调递减。
 * 如果当前弹出的元素是队列中第一个元素，则将队列中元素弹出，用if就行
 * 关键api：offerLast，offerFirst，pollLast，pollFirst，peekLast，peekFirst，，
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!queue.isEmpty()&&queue.peekLast()<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        res[0]=queue.peekFirst();

        for(int i=1;i<nums.length-k+1;i++){
            if (!queue.isEmpty()&&queue.peek()==nums[i-1]){
                queue.pollFirst();
            }
            while(!queue.isEmpty()&&queue.peekLast()<nums[i+k-1]){
                queue.pollLast();
            }
            queue.offerLast(nums[i+k-1]);
            res[i]=queue.peekFirst();
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = new int[]{-7,-8,7,5,7,1,6,0};
        int k = 3;
        maxSlidingWindow test=new maxSlidingWindow();
        int[] res=test.maxSlidingWindow(nums,k);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
