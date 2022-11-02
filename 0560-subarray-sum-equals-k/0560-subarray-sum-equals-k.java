class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        int currSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(map.containsKey(currSum-k)){
                ans += map.get(currSum-k);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);            
        }
        
        return ans;
        
        
    }
}