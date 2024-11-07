package com.perfectcode.aida2.debug_test.Hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/11/1 3:29
 */

/**
 *
 */
public class Splitpalindrome {

    List<List<String>> result = new ArrayList<List<String>>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }
    public void backtracking(String s,int startIndex){
        //终止条件，当startIndex等于s的长度时，说明找到了一组分割方案
        if(startIndex >= s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex,i+1);
            //只有符合回文串才加入到path中，然后递归，回溯
            if(isPalindrome(str)){
                path.add(str);
                backtracking(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        //while循环简化代码
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
