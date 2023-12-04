class StockPrice {
    TreeSet<int[]> stack, values;
    HashMap<Integer,Integer> m;
    public StockPrice() {
        stack= new TreeSet<>((a,b)-> a[0]-b[0]);
        values= new TreeSet<>((a,b)-> a[1]==b[1]? a[0]-b[0]: a[1]-b[1]);
        m=new HashMap<>();
    }
    
    public void update(int timestamp, int price) {
        
        if(!m.containsKey(timestamp)){
            int[] v= new int[]{timestamp, price};
            stack.add(v);
            values.add(v);
            m.put(timestamp,price);
        }else{
            int v= m.get(timestamp);
            int[] remove=new int[]{timestamp,v};
            stack.remove(remove);
            values.remove(remove);
            stack.add(new int[]{timestamp,price});
            values.add(new int[]{timestamp,price});
            m.remove(timestamp);
            m.put(timestamp,price);
        }
    }
    
    public int current() {
        return stack.last()[1];
    }
    
    public int maximum() {
        return values.last()[1];
    }
    
    public int minimum() {
        return values.first()[1];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */