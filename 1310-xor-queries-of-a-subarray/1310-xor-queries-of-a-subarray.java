class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xorArr = new int[n];
        int[] res = new int[queries.length];
        xorArr[0] =arr[0];
        for(int i = 1; i < n; i++) {
            xorArr[i] = xorArr[i-1] ^ arr[i];
        }
        
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            
            res[i] = xorArr[end] ^ (start == 0 ? 0 : xorArr[start-1]);
        }
        
        return res;
        
    }
}