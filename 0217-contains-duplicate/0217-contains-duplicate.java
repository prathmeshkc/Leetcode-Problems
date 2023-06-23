class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int e: nums) {
            if(map.containsKey(e)) {
                return true;
            }else {
                map.put(e, 1);
            }
        }
        return false;
    }
}