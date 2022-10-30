class Solution {
    public int maximumWealth(int[][] accounts) {
    
        int maxWealth = 0;
        
       for(int i=0; i<accounts.length; i++){
           int runningSum = 0;
           for(int j=0; j<accounts[i].length; j++){
               runningSum += accounts[i][j];
           }
           
           if(runningSum > maxWealth){
               maxWealth = runningSum; 
           }
       }
        
        return maxWealth;
        
    }
}