class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //start from bottom-left
        int row = m-1;
        int col = 0;
        
        while(row>=0 && col<n) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        
        return false;
        
    }
}