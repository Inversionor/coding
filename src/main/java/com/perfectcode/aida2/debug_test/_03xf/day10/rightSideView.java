package com.perfectcode.aida2.debug_test._03xf.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * 199.二叉树的右视图
 */
public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,0,list);
        return list;


    }
    private void dfs(TreeNode root ,int deep,List<Integer> list){
        if(root==null){
            return ;
        }
        if(deep == list.size()){
            list.add(root.val);
        }
        dfs(root.right,deep+1,list);
        dfs(root.left,deep+1,list);
    }
}
