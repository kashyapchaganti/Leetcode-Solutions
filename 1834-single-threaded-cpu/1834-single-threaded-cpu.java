class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Pair[] nums = new Pair[n];
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            nums[i]= new Pair(i,tasks[i][0],tasks[i][1]);
        }
        Arrays.sort(nums, (a,b)-> a.startTime-b.startTime);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.processingTime==b.processingTime? a.idx-b.idx:a.processingTime-b.processingTime);
        int taskIndex =0, ansIndex=0;
        int currentTime= 0;
        while(taskIndex<n || !pq.isEmpty()){
            
            if(pq.isEmpty() && currentTime<=nums[taskIndex].startTime){
                currentTime=nums[taskIndex].startTime;
            }
            
            while(taskIndex<n && currentTime>= nums[taskIndex].startTime){
                pq.add(nums[taskIndex]);
                taskIndex++;
            }
            
            Pair curTask = pq.poll();
            int curIndex = curTask.idx;
            currentTime+=curTask.processingTime;
            
            res[ansIndex++]=curIndex;
            
        }
        return res;
        
        
    }
}
class Pair{
    int idx, startTime, processingTime; 
    public Pair(int idx,int startTime, int processingTime){
        this.idx= idx;
        this.startTime= startTime;
        this.processingTime= processingTime;
    }
}