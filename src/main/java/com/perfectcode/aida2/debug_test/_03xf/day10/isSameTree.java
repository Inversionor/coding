package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 100.相同的树
 */

public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q ==null){
            return p == q ? true :false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}
