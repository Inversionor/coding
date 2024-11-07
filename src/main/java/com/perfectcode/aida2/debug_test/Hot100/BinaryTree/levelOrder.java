package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:06
 */

/**
 * 层序遍历
 * 思路：先创建一个全局的集合，来存储每一层的结果
 * 通过一个deep来判断第几层，如果说集合的桶小于层数，则加桶
 * 之后再将值添加到集合中，并且递归调用左右节点。
 * 关键api：resList.get(deep-1).add(root.val);
 *
 */
public class levelOrder {
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root,0);
        return resList;
    }
    public void checkFun(TreeNode root , Integer deep){
        if(root ==null){
            return;
        }
        deep++;
        if(resList.size()<deep){
            List<Integer> res = new ArrayList<Integer>();
            resList.add(res);
        }
        resList.get(deep-1).add(root.val);
        checkFun(root.left,deep);
        checkFun(root.right,deep);
    }
}
