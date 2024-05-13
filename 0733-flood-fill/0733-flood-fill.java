class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        this.dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
        };
        
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            for(int[] dir: this.dirs) {
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                if(nr >= 0 && nr < m && nc >=0 && nc < n && image[nr][nc] == originalColor) {
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        
        return image;
    }
}