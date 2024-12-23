package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class buildTree {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            //快速获取中序遍历的下标
            dic.put(inorder[i], i);
        //left和right是作为inorder数组中进行指针的终止条件
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);        // 建立根节点
        //获取根节点在inorder的下标
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        //左子树的根节点的下标就是preorder的上一个根节点的坐标+1
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        //> i - left + root + 1`含义为 `根节点索引 + 左子树长度 + 1`
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }
    public static void main(String[] args) {
        buildTree buildTree = new buildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}