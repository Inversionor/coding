package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */

public class connect {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        List<Node> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()){
            List<Node> nxt = new ArrayList<>();
            for(int i =0;i<cur.size();i++){
                Node node = cur.get(i);
                if(i==cur.size()-1){
                    node.next = null;
                }else{
                    node.next = cur.get(i+1);
                }
                if(node.left!=null){
                    nxt.add(node.left);
                }
                if(node.right!=null){
                    nxt.add(node.right);
                }
            }
            cur = nxt;
        }
        return root;
    }
}


