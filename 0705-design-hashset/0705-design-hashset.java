class MyHashSet {

    private boolean storage[][];
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.buckets][];
    }
    
    private int hash1(int key) {
        return key%this.buckets;
    }
    
    private int hash2(int key) {
        return key/this.bucketItems;
    }
    
    public void add(int key) {
        int bucketPos = hash1(key);
        int bucketItemPos = hash2(key);
        if(this.storage[bucketPos] == null) {
            if(bucketPos == 0) {
                this.storage[bucketPos] = new boolean[this.bucketItems + 1];
            } else {
                this.storage[bucketPos] = new boolean[this.bucketItems];
            }
        }
        this.storage[bucketPos][bucketItemPos] = true;
    }
    
    public void remove(int key) {
        int bucketPos = hash1(key);
        int bucketItemPos = hash2(key);
        if(this.storage[bucketPos] == null) return;
        this.storage[bucketPos][bucketItemPos] = false;
    }
    
    public boolean contains(int key) {
        int bucketPos = hash1(key);
        int bucketItemPos = hash2(key);
        if(this.storage[bucketPos] == null) return false;
        return this.storage[bucketPos][bucketItemPos];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */