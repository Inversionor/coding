package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:50
 */

/**
 * 返回右视图
 * 层序遍历，每层只保留最后一个节点
 */
public class rightSideView {
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<Integer> rightSideView(TreeNode root) {
        checkFun(root,0);
        List<Integer> result = new ArrayList<>();
        int length = resList.size();
        for(int i =0;i<length;i++){
            List<Integer> tmp = resList.get(i);
            int length2 = tmp.size();
            result.add(tmp.get(length2-1));
        }
        return result;



    }
    public void checkFun(TreeNode root , Integer deep){
        if(root==null){
            return;
        }
        deep++;
        if(resList.size()<deep){
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep-1).add(root.val);
        checkFun(root.left,deep);
        checkFun(root.right,deep);
    }
}
