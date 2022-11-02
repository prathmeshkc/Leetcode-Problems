class Solution {
    public int longestConsecutive(int[] nums) {
         
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int val: nums){
            list.add(val);
        }
        
        //NeetCode approach
        
        HashSet<Integer> set = new HashSet<Integer>(list);
       
        int maxLength = 0;
        
        
        for(int val: nums){
            
            if(!set.contains(val-1)){
                int length = 0;
                while(set.contains(val+length)){
                    length++;
                }
                
                if(length > maxLength){
                    maxLength = length;
                }
                
            }
            
            
        }
        
        return  maxLength;
        
        
        
        
        /**
        Sumeet Malik's approach
        
        1. Make a hashmap of Int vs Bool and store each element in the map with initial value as true. (true denoting that each element is the start of sequence.
        2. in the 2nd for-loop, if the n = element - 1 is present in the map then the element is not the start of sequence so map t to false. Now the start element of the possible sequencces will remain true.
        3. initialize length = 0
        4. 3rd for-loop, if the value of key is true, run a while loop untill map contains the key = element+ 1 + 1 + 1 + ...... IF present, increment the length.
        5. At last compare the length and maxLength and return maxLength
        
            Works for 69/72 test cases but for very large input (nums.length ~= 10^5) it throws time lmit exceeded
        **/
        
        /**
        if(nums.length < 1){
            return 0;
        }
        
       
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        
        for(int val: nums){
            map.put(val, true);
        }
         
        for(int val: nums){
            if(!map.containsKey(val-1)){
                map.put(val, false);
            }
        }
        
        int maxLen = 0;

        for(int val: nums){
            if(map.get(val) == true){
                int tempLen = 1;
                int tempStartPoint = val;
                
                while(map.containsKey(tempStartPoint + tempLen)){
                    tempLen++;
                }
                
                if(tempLen > maxLen){
                    maxLen = tempLen;
                }
                
                
                
            }
        }
        
        
        return maxLen+1;
        **/
        
    }
}