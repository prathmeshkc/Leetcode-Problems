class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int rows = coins.length;
        int cols = amount;
        
        int[][] dp = new int[rows+1][cols+1];
        dp[0][0] = 0;
        
        for(int i=1; i<=cols; i++) {
            dp[0][i] = 99999;
        }
        
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
                
            }
        }
        
        int res = dp[rows][cols];
        
        if(res == 99999) return -1;
        return res;
    }
}