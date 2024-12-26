package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class connect2 {
    private final List<Node> pre = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0); // 根节点的深度为 0
        return root;
    }

    private void dfs(Node node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == pre.size()) { // node 是这一层最左边的节点
            pre.add(node);
        } else { // pre[depth] 是 node 左边的节点
            pre.get(depth).next = node; // node 左边的节点指向 node
            pre.set(depth, node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}
