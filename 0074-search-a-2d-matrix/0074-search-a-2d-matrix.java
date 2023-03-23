class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int row = 0;
        
        while(col >=0 && row <= matrix.length-1){
            
            int curr = matrix[row][col];
            
            if(target < curr) {
                col--;
            }else if(target > curr){
                row++;
            }else{
                return true;
            }            
        }
        
        return false;
        
    }
}