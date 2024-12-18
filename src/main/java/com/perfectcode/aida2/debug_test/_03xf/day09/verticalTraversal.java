package com.perfectcode.aida2.debug_test._03xf.day09;

import java.util.*;


/**
 * 987.二叉树的垂序遍历
 * 对于List<int[]>,直接添加元素是new ArrayList<>().add(new int[]{row, node.val});
 * 对于ArrayList<List<Integer>>直接添加元素是new ArrayList<>().add(Arrays.asList(row,node.val));
 */

public class verticalTraversal {
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //实现一：
//        //使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
//        Map<Integer,List<int[]>> groups = new TreeMap<>();
//        dfs(root,0,0,groups);
//
//        List<List<Integer>> ans = new ArrayList<>(groups.size());
//        for(List<int[]> g : groups.values()){
//            g.sort((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
//            List<Integer> vals = new ArrayList<>(g.size());
//            for(int[] p :g){
//                vals.add(p[1]);
//            }
//            ans.add(vals);
//        }
//        return ans;
//    }
//    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups) {
//        if (node == null) {
//            return;
//        }
//
//        // col 相同的分到同一组，如果不存在col 就创建一个ArrayList并且把node.val 放入其中；
//        //传统写法
//        //if (!groups.containsKey(col)) {
//        //    groups.put(col, new ArrayList<>());
//        //}
//        //groups.get(col).add(new int[]{row, node.val});
//        //如果后面没有链式调用（比如 .add(...)），则此代码仅初始化映射关系，不做其他操作。
//        groups.computeIfAbsent(col, key -> new ArrayList<>()).add(new int[]{row, node.val});
//        dfs(node.left, row + 1, col - 1, groups);
//        dfs(node.right, row + 1, col + 1, groups);
//    }
        //实现二
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer,ArrayList<List<Integer>>> groups = new TreeMap<>();
            dfs(root,0,0,groups);
            List<List<Integer>> ans = new ArrayList<>(groups.size());
            for(ArrayList<List<Integer>> g : groups.values()){
                g.sort((a, b) -> !a.get(0).equals(b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));
                List<Integer> vals = new ArrayList<>(g.size());
                for(List<Integer> p :g){
                    vals.add(p.get(1));
                }
                ans.add(vals);
            }
            return ans;
        }
    private void dfs(TreeNode node , int row,int col,Map<Integer,ArrayList<List<Integer>>> groups){
        if(node==null){
            return;
        }
        groups.computeIfAbsent(col, key -> new ArrayList<>())
                .add(Arrays.asList(row, node.val));
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1, groups);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        verticalTraversal verticalTraversal = new verticalTraversal();
        List<List<Integer>> list = verticalTraversal.verticalTraversal(root);
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
