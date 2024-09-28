class MyCircularDeque {
    
    /**
    Formula to remember in case of deq (or operations on both front and end)
    increment -> (+1) % k
    decrement -> (-1 + k) % k
    */
    
    private int[] deq;
    private int currSize;
    private int maxSize;
    private int front;
    private int rear;

    public MyCircularDeque(int k) {
        this.deq = new int[k];
        this.currSize = 0;
        this.maxSize = k;
        this.front = 0;
        this.rear = k-1;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        this.front = (this.front - 1 + maxSize) % maxSize;
        deq[front] = value;
        currSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        this.rear = (this.rear + 1) % maxSize;
        deq[rear] = value;
        currSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        deq[front] = -1;
        this.front = (this.front + 1) % maxSize;
        currSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        deq[rear] = -1;
        this.rear = (this.rear - 1 + maxSize) % maxSize;
        currSize--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return deq[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return deq[rear];
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */