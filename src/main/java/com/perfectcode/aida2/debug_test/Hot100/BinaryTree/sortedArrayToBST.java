package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:07
 */

/**
 * 没理解
 * 将有序数组转成二叉搜索树
 * 思路：递归，每次取中间值作为根节点，递归左右子树
 */
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    // 把 nums[left] 到 nums[right-1] 转成平衡二叉搜索树
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right)/2;
        return new TreeNode(nums[m], dfs(nums, left, m), dfs(nums, m + 1, right));
    }

}
