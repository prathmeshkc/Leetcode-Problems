class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //start form top-right
        int row = 0;
        int col = n-1;
        
        while(row<m && col>=0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        
        return false;
        
    }
}