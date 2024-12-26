package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.*;

/**
 * 2583.二叉树的第K大层和
 */

public class kthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = levelOrder(root);
        if (list.size()<k){
            return -1;
        }
        //a 和 b 是 long 类型，而 a - b 的结果仍然是 long。
        //在 lambda 表达式中，Comparator 接口的 compare 方法需要返回一个 int 值。
//        list.sort((long a, long b) -> (a - b));
        Collections.sort(list);
        return (long)list.get(list.size()-k);
    }
    private List<Long> levelOrder(TreeNode root)
    {
        if (root==null){
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty())
        {
            int size = deque.size();
            long values =0;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = deque.removeFirst();
                values+=node.val;
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            res.add(values);
        }
        return res;
    }
}
