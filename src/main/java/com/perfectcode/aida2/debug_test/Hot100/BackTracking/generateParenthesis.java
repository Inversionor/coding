package com.perfectcode.aida2.debug_test.Hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 思路：回溯，利用前缀和，保证:n>前缀的左括号数量>=右括号数量,如果左括号数量小于n，则添加左括号。如果
 *      右括号数量小于左括号数量，则添加右括号。
 *      new String(char[]) 的构造方法
 */
public class generateParenthesis {
    private int n;
    private List<String> ans = new ArrayList<>();
    private char[] path;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n*2];
        backtrack(0,0);
        return ans;
    }
    private void backtrack(int i ,int open){
        if(i == n*2){
            ans.add(new String(path));
            return;
        }
        if(open<n){
            path[i]='(';
            backtrack(i+1,open+1);
        }
        if(i-open<open){
            path[i]=')';
            backtrack(i+1,open);
        }
    }
    public static void main(String[] args)
    {
        generateParenthesis gp = new generateParenthesis();
        List<String> ans = gp.generateParenthesis(3);
        for(String s:ans)
            System.out.println(s);
    }
}
