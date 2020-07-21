/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class Day21_WordSearch {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1},{0, -1},{1, 0},{-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean result = dfs(board, visited, word, i, j, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited,
                        String word, int row, int col, int index) {
        
        if (board[row][col] != word.charAt(index)) return false;
        if (index + 1 == word.length()) return true;
        visited[row][col] = true;
        boolean result = false;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0], newCol = col + dir[1];
            boolean outOfBounds = newRow < 0 || newRow >= board.length || 
                newCol < 0 || newCol >= board[newRow].length;
            
            if (!outOfBounds && !visited[newRow][newCol]) {
                result = dfs(board, visited, word, newRow, newCol, index + 1);
                if (result) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}