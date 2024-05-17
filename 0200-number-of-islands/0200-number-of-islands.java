class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
        };
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, dirs, i, j, m, n);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int[][] dirs, int row, int col, int m, int n) {
        //base
        if(row < 0 || col < 0 || row == m || col == n || grid[row][col] == '0') return;
        //logic
        grid[row][col] = '0';
        for(int[] dir: dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, dirs, nr, nc, m, n);
        }
    }
}