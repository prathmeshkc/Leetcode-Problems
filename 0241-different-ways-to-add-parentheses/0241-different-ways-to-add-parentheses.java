class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
    
    private List<Integer> solve(String exp) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> leftRes = solve(exp.substring(0, i));
                List<Integer> rightRes = solve(exp.substring(i+1, exp.length()));
                
                for(int left: leftRes) {
                    for(int right: rightRes) {
                        if(c == '+') {
                            res.add(left + right);
                        } else if(c == '-') {
                            res.add(left - right);
                        } else if(c == '*') {
                            res.add(left * right);
                        }
                    }
                }   
            }
        }
        
        if(res.isEmpty()) res.add(Integer.parseInt(exp));
        
        return res;
    }
}