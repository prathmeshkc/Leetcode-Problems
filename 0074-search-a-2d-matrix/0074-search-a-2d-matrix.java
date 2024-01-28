class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //total row
        int n = matrix[0].length; // total col
        
        int low = 0;
        int high = m*n-1;
        
        while(low <= high) {
            int mid = (high-low)/2 + low;
            
            int row = mid / n;
            int col = mid % n;
            
            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}