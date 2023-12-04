class MaxStack {
    TreeSet<int[]> stack, values;
    int id=0;
    public MaxStack() {
        stack= new TreeSet<>((a,b)-> a[0]-b[0]); // id, value
        values= new TreeSet<>((a,b)-> a[1]==b[1]? a[0]-b[0]:a[1]-b[1]);
    }
    
    public void push(int x) {
        stack.add(new int[]{id,x});
        values.add(new int[]{id,x});
        id++;
    }
    
    public int pop() {
       int[] remove= stack.last();
        stack.remove(stack.last());
        values.remove(remove);
        return remove[1];
    }
    
    public int top() {
        return stack.last()[1];
        
    }
    
    public int peekMax() {
        return values.last()[1];
    }
    
    public int popMax() {
        int[] remove= values.last();
        
        values.remove(values.last());
        
        stack.remove(remove);
        
        return remove[1];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */