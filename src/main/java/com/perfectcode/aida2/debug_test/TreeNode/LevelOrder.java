package com.perfectcode.aida2.debug_test.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/13 21:09
 */
public class LevelOrder {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root,0);
        return resList;
    }
    /*每个栈帧都有自己独立的局部变量空间，方法的参数和局部变量在各自的栈帧中保存，它们在递归调用时不会相互干扰。*/
    public void checkFun(TreeNode node,Integer deep) {
        if (node == null) return;
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun(node.left, deep);
        checkFun(node.right, deep);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrder(root);
        System.out.println(levelOrder.resList);
    }
}
