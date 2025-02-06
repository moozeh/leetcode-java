class MyHashMap {
    int[] hash;
    boolean[] used;

    public MyHashMap() {
        hash = new int[1000001];
        used = new boolean[1000001];
    }
    
    public void put(int key, int value) {
        used[key] = true;
        hash[key] = value;
    }
    
    public int get(int key) {
        if (!used[key]) return -1;
        return hash[key];
    }  
    
    public void remove(int key) {
        used[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */