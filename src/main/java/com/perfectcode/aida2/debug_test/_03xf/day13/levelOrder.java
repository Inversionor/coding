package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 */
public class levelOrder {
//    //方法一：不使用队列
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null){
//            return new ArrayList<>();
//        }
//        List<List<Integer>> resList = new ArrayList<>();
//        List<TreeNode> cur = new ArrayList<>(Arrays.asList(root));
//        while(!cur.isEmpty()){
//            //记录当前层的左右节点
//            List<TreeNode> next = new ArrayList<>();
//            //记录当前层的值
//            List<Integer> values = new ArrayList<>();
//            for (TreeNode node : cur){
//                values.add(node.val);
//                if (node.left != null){
//                    next.add(node.left);
//                }
//                if (node.right != null){
//                    next.add(node.right);
//                }
//            }
//            resList.add(values);
//            cur = next;
//        }
//        return resList;
//
//    }
    //方法二：队列。每次使用把当前层的元素去掉，然后把下一层的元素入队
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            List<Integer> values = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.pollFirst();
                values.add(node.val);
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            resList.add(values);
        }
        return resList;

    }
}
