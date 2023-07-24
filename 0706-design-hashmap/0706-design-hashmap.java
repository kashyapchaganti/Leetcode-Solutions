class MyHashMap {
    int m = (int)(1e9+7);
    Bucket b;
    public MyHashMap() {
        b= new Bucket();
    }
    
    public void put(int key, int value) {
        b.update(key,value);
        return ;
    }
    
    public int get(int key) {
        return b.get(key);
    }
    
    public void remove(int key) {
        b.remove(key);
        return;
    }
}
class Bucket{
    public List<Pair> b;
    public Bucket(){
        this.b=b;
        b = new ArrayList<>();
    }
    public int get(int x){
        for(Pair y: b){
            if(y.r==x){
                return y.c;
            }
        }
        return -1;
    }
    public void update(int x, int y){
        boolean f =false;
        for(Pair a: b){
            if(a.r==x){
                f=true;
                a.c=y;
            }
        }
        if(f==false){
            b.add(new Pair(x,y));
        }
    }
    public void remove(int k){
        for(Pair x:b){
            if(x.r==k){
                b.remove(x);
                return;
            }
        }
    }
}
class Pair{
    int r;
    int c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */