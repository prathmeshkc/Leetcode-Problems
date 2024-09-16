class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        
        for(String timePoint: timePoints) {
            String hourStr = timePoint.substring(0, 2);
            String minStr = timePoint.substring(3, 5);
            
            int hour = Integer.parseInt(hourStr);
            int min = Integer.parseInt(minStr);
            
            int totalMins = hour * 60 + min;
            minutesList.add(totalMins);
        }
        
        Collections.sort(minutesList);
        
        int minDiff = Integer.MAX_VALUE;
        int n = minutesList.size();
        for(int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutesList.get(i) - minutesList.get(i-1));
            
        }
        
        return Math.min(minDiff, (24*60 - minutesList.get(n - 1)) + minutesList.get(0));
    }
}