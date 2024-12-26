package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 199.二叉树的右视图
 */

public class rightSideView {
//    //dfs
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> rightSideView(TreeNode root) {
//        dfs(root,0);
//        return list;
//    }
//    private void dfs(TreeNode root,int depth){
//        if(root==null){
//            return ;
//        }
//        if(depth==list.size()){
//            list.add(root.val);
//        }
//        dfs(root.right,depth+1);
//        dfs(root.left,depth+1);
//    }
    //bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            for(int i=0;i<size;i++){
                TreeNode node = list.remove(0);
                if(i==size-1){
                   res.add(node.val);
                }
                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
        }
        return res;
    }


}
