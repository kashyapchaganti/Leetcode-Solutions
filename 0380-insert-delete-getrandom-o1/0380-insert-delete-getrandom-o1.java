class RandomizedSet {
    HashMap<Integer, Integer> m;
    ArrayList<Integer> arr;
    Random ran;
    
    public RandomizedSet() {
        m = new HashMap<>();
        arr = new ArrayList<>();
        ran= new Random();
        
    }
    
    public boolean insert(int val) {
        if(m.containsKey(val)){
            return false;
        }
        m.put(val,m.size());
        arr.add(arr.size(),val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!m.containsKey(val)){
            return false;
        }
        int x = arr.get(arr.size()-1);
        int y=m.get(val);
        arr.set(y,x);
        arr.remove(arr.size()-1);
        m.put(x,y);
        m.remove(val);
        return true;
    }
    
    public int getRandom() {
        return arr.get(ran.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */