class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        
        int top = 0;
        int bottom = n - 1;
        
        int left = 0;
        int right = n - 1;
        
        while(num <= n*n && top <= bottom && left <= right) {
            //top row l -> r
            for(int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            top++;
            
            //right col u -> d
            for(int i = top; i <= bottom; i++) {
                res[i][right] = num;
                num++;
            }
            right--;
            
            //bottom row r -> l
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    res[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            
            //left col d -> u
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    res[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        
        return res;
    }
}