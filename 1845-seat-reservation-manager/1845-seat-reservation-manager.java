class SeatManager {
    TreeSet<Integer> s =new TreeSet<>();
    public SeatManager(int n) {
        for(int i=1;i<=n;i++){
            s.add(i);
        }
    }
    
    public int reserve() {
        if(s.size()>0){
            
            int a= s.first();
            s.remove(a);
            return a;
        }
        return -1;
    }
    
    public void unreserve(int seatNumber) {
        s.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */