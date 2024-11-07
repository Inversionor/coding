    package com.perfectcode.aida2.debug_test.Hot100.BackTracking;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    /**
     * N皇后
     * 思路：1.写一个回溯。2.写一个判断棋盘是否合法 3.写一个二位数组转List
     * 1.以列作为树层，以行作为树枝，当行数等于棋盘的尺寸n的时候，就添加符合题意的答案。
     *   在进行for循环的时候，要注意棋盘是否合法，如果合法则可以给位置添加皇后
     * 2.棋盘合法主要是判断45°，135°和90°是否合法，利用for循环遍历看看对应位置上是否有皇后即可
     * 3.二维数组转List的关键在于把char[][]的某一列转换为String，有对应的api，String.copyValueOf(char[])
     *
     */
    public class solveNQueens {
        List<List<String>> result = new ArrayList<List<String>>();
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] row : board){
                Arrays.fill(row,'.');
            }
            backTracking(n,0,board);
            return result;
        }
        public void backTracking(int n ,int row , char[][] board) {
            if (row == n) {
                result.add(Arrays2List(board));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isValid(board,row,col,n)){
                    board[row][col] = 'Q';
                    backTracking(n,row+1,board);
                    board[row][col] = '.';
            }
            }
        }
        public List<String> Arrays2List(char[][] board) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(String.copyValueOf(row));
            }
            return list;
        }
        public boolean isValid (char[][] chessboard,int row ,int col,int n ) {
            for (int i=0; i<row; ++i) { // 相当于剪枝
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;

        }

    }
