class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();        
        
        for(String s: tokens){
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                stack.push(Integer.parseInt(s));
            }else{
                if(s.equals("+")){
                    stack.push(stack.pop() + stack.pop());
                }else if(s.equals("-")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                }else if(s.equals("*")){
                    stack.push(stack.pop() * stack.pop());
                }
                else{
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            }
        }
        
        return stack.peek();
    }
}