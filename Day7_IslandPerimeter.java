/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

 */
public class Day7_IslandPerimeter {
    int p, n, m;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        this.n = n;
        if (n == 0)
            return 0;
        
        int m = grid[0].length;
        this.m = m;
        if (m == 0)
            return 0;
        
        boolean visited[][] = new boolean[n][m];
        int i = 0, j = 0;
        // Find first one. 
        outer: for (i=0; i<n; i++) {
            for (j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i,j, grid, visited);
                    break outer;
                }
            }
        }
        
        return p;
    }
    
    void dfs(int x, int y, int[][]grid, boolean[][]visited)
    {
        visited[x][y] = true;
        
        this.p += perimeter(x, y, grid);
        
        int []dx = new int[]{-1, 1, 0, 0};
        int []dy = new int[]{0, 0, 1, -1};
        
        for (int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isValid(nx, ny) && visited[nx][ny] == false && grid[nx][ny] == 1) {
                dfs(nx, ny, grid, visited);
            }
        }
    }
    
    boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    int perimeter(int x, int y, int grid[][]) {
        int cnt = 0;
        
        if (x == 0 || grid[x-1][y] == 0) 
            cnt++;
        if (x == n -1 || grid[x+1][y] == 0)
            cnt++;
        if (y==0 || grid[x][y-1] == 0)
            cnt++;
        if (y== m -1 || grid[x][y+1] == 0)
            cnt++;
        
        return cnt;
    }
}