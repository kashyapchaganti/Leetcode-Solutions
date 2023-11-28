class TimeMap {
    HashMap<String,TreeMap<Integer,String>> m;
    public TimeMap() {
        m= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!m.containsKey(key)){
            m.put(key, new TreeMap<>());
        }
        m.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)){
            return "";
        }
        TreeMap<Integer,String> m1 = m.get(key);
        int v= -1;
        if(m1.floorKey(timestamp)!=null){
             v=m1.floorKey(timestamp);
        }
        if(v==-1) return "";
        return m1.get(v);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */