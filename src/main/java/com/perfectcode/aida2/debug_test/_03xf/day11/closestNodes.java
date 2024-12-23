package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 2476.二叉搜索树最近节点查询
 */

public class closestNodes {
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int q : queries){
            int l = -1;
            int r = list.size();
            while(l+1<r){
                int mid = l+(r-l)/2;
                if(list.get(mid) >= q){
                    r=mid;
                }else if(list.get(mid) < q){
                    l=mid;
                }
            }
            if (r==list.size()&&list.get(r-1)!=q){
                ans.add(List.of(list.get(r-1),-1));
            }else if (r==0&&list.get(r)!=q){
                ans.add(List.of(-1,list.get(0)));
            }else if (list.get(r)==q){
                ans.add(List.of(q,q));
            }else {
                ans.add(List.of(list.get(r-1),list.get(r)));
            }
        }
        return ans;


    }
    private void dfs(TreeNode root){
        if(root ==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
