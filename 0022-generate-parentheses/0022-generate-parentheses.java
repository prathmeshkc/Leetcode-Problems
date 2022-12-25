class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res,"", 0, 0, n);
        return res;
    }
    
    //Using backtracking here.
    //Backtracking has template like:-
    /*
        1. Base Case
        2 and onwards are the conditions.
    */
    private static void backtrack(List<String> res, String curr_Str, int open, int close, int n){
        
        if(curr_Str.length() == n*2){
            res.add(curr_Str);
            return;
        }
        
        if(open<n){
            backtrack(res, curr_Str + "(", open+1, close, n);
        }
        
        if(close<open){
            backtrack(res, curr_Str + ")", open, close+1, n);
        }        
    }
}