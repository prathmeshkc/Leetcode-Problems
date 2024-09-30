class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] res = new int[m][n];
        
        if(original.length != m*n) return new int[0][0];
        
        int start = 0;
        int end = n;
        
        for(int i = 0; i < m; i++) {
            res[i] = Arrays.copyOfRange(original, start, end);
            start = end;
            end = end + n;
        }
        
        return res;
    }
}