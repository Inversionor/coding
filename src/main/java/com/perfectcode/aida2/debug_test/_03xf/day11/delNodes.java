package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1110.删点成林
 * 1.可以用哈希表快速判断一个节点值是否在待删除数组中
 * 2.如果当前节点被删除，但是左儿子（右儿子）没被删除，意味着左儿子（右儿子）是一棵树的根节点，加入答案。
 * 3.从下往上比较好做
 */

public class delNodes {
    List<TreeNode> tmp=new ArrayList<>();
    List<TreeNode> ans=new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        dfs(root, to_delete);
        if (!find(to_delete, root.val)){
            ans.add(root);
        }
        for (TreeNode node : tmp) {
            if (node.left != null) ans.add(node.left);
            if (node.right != null) ans.add(node.right);
        }
        return ans;


    }
    private TreeNode dfs(TreeNode root, int[] to_delete) {
        if (root == null) {
            return null;
        }
        if (find(to_delete, root.val)){
            tmp.add(root);
            root.left=dfs(root.left, to_delete);
            root.right=dfs(root.right, to_delete);
            return null;
        }
        root.left = dfs(root.left, to_delete);
        root.right = dfs(root.right, to_delete);
        return root;

    }
    private boolean find(int[] to_delete, int target) {
        Arrays.sort(to_delete);
        int left = -1, right = to_delete.length ;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (to_delete[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left == -1){
            return false;
        }else {
            return to_delete[left] == target;
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=null;
        root.left.right=null;
        root.right.left=null;
        root.right.right=new TreeNode(4);
        int[] to_delete={2,1};
        delNodes delNodes=new delNodes();
        List<TreeNode> ans=delNodes.delNodes(root,to_delete);
        for (TreeNode node : ans) {
            System.out.println(node.val);
        }
    }
}
