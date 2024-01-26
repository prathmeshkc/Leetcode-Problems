class MyQueue {

    private Stack<Integer> pushSt;
    private Stack<Integer> popSt;
    
    public MyQueue() {
        this.pushSt = new Stack<>();
        this.popSt = new Stack<>();
    }
    
    public void push(int x) {
        this.pushSt.push(x);
    }
    
    public int pop() {
        if(this.popSt.isEmpty()) {
            while(!this.pushSt.isEmpty()) {
                this.popSt.push(this.pushSt.pop());
            }
        }
        return this.popSt.pop();
    }
    
    public int peek() {
        if(this.popSt.isEmpty()) {
            while(!this.pushSt.isEmpty()) {
                this.popSt.push(this.pushSt.pop());
            }
        }
        return this.popSt.peek();
    }
    
    public boolean empty() {
        return this.pushSt.isEmpty() && this.popSt.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */