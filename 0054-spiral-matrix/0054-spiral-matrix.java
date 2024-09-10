class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> res = new ArrayList<>();
        
        int top = 0;
        int bottom = m - 1;
        
        int left = 0;
        int right = n - 1;
        
        while(top <= bottom && left <= right) {
            //top row L -> R
            for(int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            
            
            //right column U -> D
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            //bottom row R -> L
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //left column D -> U
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return res;
    }
}