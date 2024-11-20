package com.perfectcode.aida2.debug_test.Hot100.BackTracking;

/**
 * 单词搜索
 *
 */
public class exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //因为一个棋盘有四个方向，所以只需要判断四个方向即可，但是四个方向有可能超过边界
        //所以四个方向需要判断是否越界，以及当前位置是否和word[k]相等。
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        //已经访问过的棋盘位置置为空，避免重复访问
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //用于恢复被标记的字符，也是回溯的灵魂
        board[i][j] = word[k];
        //返回从当前节点 (i, j) 出发是否找到了单词的剩余部分
        return res;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist exist = new exist();
        System.out.println(exist.exist(board, word));
    }

}
