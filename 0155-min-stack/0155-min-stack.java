class MinStack {
    Stack<Integer> stack;
    
    public MinStack() {
        this.stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.stack.push(val);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return (int)this.stack.peek();
    }
    
    public int getMin() {
        int min = this.stack.peek();
        for(Integer e: this.stack){
            if(e < min){
                min = e;
            }        
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */