class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a,b)-> b-a);
        for(int i=0;i<piles.length;i++){
maxHeap.add(piles[i]);
}
        while(!maxHeap.isEmpty()){
            
int cur =maxHeap.poll();
            cur=cur-(int)Math.floor(cur/2);
            maxHeap.add(cur);
            k--;
            if(k==0){
break;}

        }
int s=0;
        while(!maxHeap.isEmpty()){
s+=maxHeap.poll();

}
        return s;
    }
}