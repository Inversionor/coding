package com.perfectcode.aida2.debug_test._03xf.day12;

/**
 * 2096.从二叉树的一个节点到另一个节点每一步的方向
 * 1.在 dfs 中，startPath 和 destPath 直接指向 path 的引用，而 path 是递归共享的。
 *  后续递归的修改会影响之前保存的路径，导致路径结果不正确。
 * 2.在递归调用 dfs 后，你没有回溯（删除 path 中追加的字符），会导致路径被污染，影响正确性。
 */
public class getDirections {
    private StringBuilder startPath;
    private StringBuilder destPath;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        startPath = new StringBuilder();
        destPath = new StringBuilder();

        dfs(root, startValue, destValue, new StringBuilder());

        // 找到公共前缀长度
        int commonLength = 0;
        while (commonLength < startPath.length() && commonLength < destPath.length()
                && startPath.charAt(commonLength) == destPath.charAt(commonLength)) {
            commonLength++;
        }

        // 从起点到公共祖先的 "U" 移动
        String upMoves = "U".repeat(startPath.length() - commonLength);

        // 从公共祖先到终点的路径
        String downMoves = destPath.substring(commonLength);

        return upMoves + downMoves;
    }

    private boolean dfs(TreeNode root, int startValue, int destValue, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == startValue) {
            startPath = new StringBuilder(path);
        }
        if (root.val == destValue) {
            destPath = new StringBuilder(path);
        }

        // 递归到左子树
        path.append("L");
        boolean foundInLeft = dfs(root.left, startValue, destValue, path);
        path.deleteCharAt(path.length() - 1); // 回溯

        // 递归到右子树
        path.append("R");
        boolean foundInRight = dfs(root.right, startValue, destValue, path);
        path.deleteCharAt(path.length() - 1); // 回溯

        return foundInLeft || foundInRight || root.val == startValue || root.val == destValue;
    }

    public static void main(String[] args) {
        // 测试用例
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        getDirections obj = new getDirections();
        System.out.println(obj.getDirections(root, 3, 4)); // "UUR"
        System.out.println(obj.getDirections(root, 3, 2)); // "UUUUR"
        System.out.println(obj.getDirections(root, 1, 2)); // "R"
    }
}
