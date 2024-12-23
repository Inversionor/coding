package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */

public class buildTree2 {
    int[] postorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++)
            //快速获取中序遍历的下标
            dic.put(inorder[i], i);
        return recur(postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(postorder[root]);
        int i = dic.get(postorder[root]);
        node.left= recur(root-(right-i) -1, left, i - 1);
        node.right = recur(root-1, i + 1, right);
        return node;
    }
    public static void main(String[] args) {
        buildTree2 b = new buildTree2();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = b.buildTree(inorder, postorder);
        System.out.println(root);
    }
}
