package com.perfectcode.aida2.debug_test.TreeNode;

import java.util.*;


public class Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);         // 添加当前节点的值
        preorder(root.left, result);  // 遍历左子树
        preorder(root.right, result); // 遍历右子树
    }

    public void inorder(TreeNode root, List<Integer> result) {{
        if (root ==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }}

    public void postorder(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }

    public List<Integer> preorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }
    /*相当于右子树的前序遍历。最后反转一下结果就行*/
    public List<Integer> postorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right !=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }


}
