class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // {idx,weight, time}
        PriorityQueue<int[]> free = new PriorityQueue<>((a,b)->a[1]==b[1]? a[0]-b[0]:a[1]-                                                                b[1]);
        int j=0;
        for(int server: servers ){
            free.add(new int[]{j,server,0});
            j++;
        }
        
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b)-> a[2]==b[2]?a[1]==b[1]? a[0]-b[0]:a[1]-                                                                b[1]:a[2]-b[2]);
        int[] res = new int[tasks.length];
        
        for(int i=0;i<tasks.length;i++){
            int t= tasks[i];
            while(!busy.isEmpty() && busy.peek()[2]<=i){
                
                
                free.add(busy.poll());
            }
            
            if(free.isEmpty()){
                int[] cur= busy.poll();
                res[i]= cur[0];
                cur[2]+=t;
                busy.add(cur);
            }else{
                int[] cur = free.poll();
                res[i]= cur[0];
                cur[2]=i+t;
                busy.add(cur);
            }
        }
        return res;
        
    }
}