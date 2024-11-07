package com.perfectcode.aida2.debug_test.TreeNode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/13 17:22
 */
public class Main {
    public static void main(String[] args) {


        // 创建一个二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        Traversal traversal = new Traversal();
        List<Integer> integers = traversal.preorderTraversal(root);
        System.out.println(integers);
        List<Integer> integers1 = traversal.preorder2(root);
        System.out.println(integers1);
        List<Integer> integers3 = traversal.postorderTraversal(root);
        System.out.println(integers3);
        List<Integer> integers2 = traversal.postorder2(root);
        System.out.println(integers2);



    }
}
