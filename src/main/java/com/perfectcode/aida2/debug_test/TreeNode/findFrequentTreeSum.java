package com.perfectcode.aida2.debug_test.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lzj
 * @Date: 2024/10/14 23:17
 */

/**
 * 508. 出现次数最多的子树元素和
 * 思路：后序遍历，求出子树元素和，然后用map存储子树元素和和出现的次数，然后遍历map，找到出现次数最多的子树元素和，然后返回。
 * 关键api: map.getOrDefault(key,0)+1;map.keySet();
 * keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
 *
 */
public class findFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postorder(root, map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int key : map.keySet()) {
            max=Math.max(max,map.get(key));
        }
        for (int key : map.keySet()){
            if (map.get(key)==max){
                list.add(key);
            }
        }
        return list.stream().mapToInt(i->i).toArray();


    }
    public int postorder(TreeNode root, Map<Integer, Integer> map)
    {
        if (root==null){
            return 0;
        }
        int leftsum = postorder(root.left, map);
        int rightsum = postorder(root.right, map);
        int sum=root.val+leftsum+rightsum;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        findFrequentTreeSum findFrequentTreeSum = new findFrequentTreeSum();
        int[] ints = findFrequentTreeSum.findFrequentTreeSum(root);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
