class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek().getKey()){
                Pair<Integer, Integer> pair = stack.pop();
                res[pair.getValue()] = i - pair.getValue();
            }
            stack.push(new Pair<Integer, Integer>(temperatures[i], i));
        }
        
        return res;
    }
}