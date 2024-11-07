package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 13:06
 */
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root,result);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
