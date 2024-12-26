package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 2641.二叉树的堂兄弟节点2️⃣
 */
public class replaceValueInTree {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val=0;
        List<TreeNode> q =List.of(root);
        while(!q.isEmpty()){
            List<TreeNode> tmp =q;
            q = new ArrayList<>();
            //计算下一层节点的节点和，然后将下一层的节点放入q中
            int nextLevelSum = 0;
            for(TreeNode node:tmp){
                if(node.left!=null){
                    q.add(node.left);
                    nextLevelSum+=node.left.val;
                }
                if(node.right!=null){
                    q.add(node.right);
                    nextLevelSum+=node.right.val;
                }
            }
            //再次遍历当前节点
            for(TreeNode node: tmp){
                int childSum=(node.left != null ? node.left.val : 0) +
                        (node.right != null ? node.right.val : 0);
                if(node.left!=null){
                    node.left.val = nextLevelSum - childSum;
                }
                if(node.right!=null){
                    node.right.val = nextLevelSum - childSum;
                }
            }
        }
        return root;



    }
}
