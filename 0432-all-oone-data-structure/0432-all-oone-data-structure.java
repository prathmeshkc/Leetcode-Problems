class AllOne {
    
    
    private static class Node {
        int count;
        LinkedList<String> keys;
        Node prev;
        Node next;
        
        public Node(int count) {
            this.count = count;
            this.keys = new LinkedList<>();
            this.prev = null;
            this.next = null;
        }
    }
    
    private Map<String, Node> map;
    private Node dummy;
    private Node last;

    public AllOne() {
        this.map = new HashMap<>();
        this.dummy = new Node(0);
        this.last = dummy;
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)) {
            if(dummy.next == null || dummy.next.count != 1) {
                addNode(dummy, 1);
            }
            dummy.next.keys.addFirst(key);
            map.put(key, dummy.next);
        } else {
            Node currNode = map.get(key);
            int currCount = currNode.count;
            
            if(currNode.next == null || currNode.next.count != currCount + 1) {
                addNode(currNode, currCount + 1);
            }
            
            currNode.next.keys.addFirst(key);
            map.put(key, currNode.next);
            currNode.keys.remove(key);
            
            if(currNode.keys.isEmpty()) removeNode(currNode);
        }
    }
    
    public void dec(String key) {
        Node currNode = map.get(key);
        int currCount = currNode.count;
        
        if(currCount == 1) {
            map.remove(key);
        } else {
            if(currNode.prev.count != currCount - 1) {
                addNode(currNode.prev, currCount - 1);
            }
            currNode.prev.keys.addFirst(key);
            map.put(key, currNode.prev);
        }
        
        currNode.keys.remove(key);
        if(currNode.keys.isEmpty()) removeNode(currNode);
    }
    
    public String getMaxKey() {
        if(last == dummy) return "";
        
        return last.keys.get(0);
    }
    
    public String getMinKey() {
        if(dummy.next == null) return "";
        
        return dummy.next.keys.get(0);
    }
    
    private void addNode(Node prevNode, int count) {
        Node newNode = new Node(count);
        
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if(newNode.next != null) {
            newNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        
        if(prevNode == last) last = newNode;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        
        if(last == node) last = node.prev;
        
        node = null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */