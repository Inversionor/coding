package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 13:10
 */
public class maxDepth {
    List<List<Integer>> res= new ArrayList<List<Integer>>();
    public int maxDepth(TreeNode root) {
        return levelOrder(root).size();
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        checkFun(root,0);
        return res;
    }
    public void checkFun(TreeNode node,Integer deep){
        if(node==null) return;
        deep++;
        if(res.size()<deep){
            List<Integer> item=new ArrayList<Integer>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);
        checkFun(node.left, deep);
        checkFun(node.right, deep);
    }
}
