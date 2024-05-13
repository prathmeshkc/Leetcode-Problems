class Solution {
    
    int[][] dirs;
    int originalColor;
    int m;
    int n;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        this.dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };
        if (image[sr][sc] == color) return image;
        this.originalColor = image[sr][sc];
        dfs(image, sr, sc, color, m, n);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int color, int m, int n) {
        //base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != this.originalColor) return;
        //logic
        image[sr][sc] = color;
        for(int[] dir: dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, color, m, n);
        }
    }
}