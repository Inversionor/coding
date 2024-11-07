package com.perfectcode.aida2.debug_test.testcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/27 18:59
 */
class Solution {
    List<List<Integer>> result= new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n,int k,int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i =startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combine(4, 2);
        System.out.println(lists);
    }
}
