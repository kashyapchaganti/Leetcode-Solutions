class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m= queries.length;
        int[] ans = new int[m];
        int[] queriesClone = queries.clone();
        HashMap<Integer,Integer> m1 = new HashMap<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        Arrays.sort(queries);
        int i=0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int q: queries){
            
            while(i<n && intervals[i][0]<=q){
                map.put(intervals[i][1]-intervals[i][0]+1, intervals[i][1]);
                i++;
            }
            while(!map.isEmpty() && map.firstEntry().getValue()<q){
                map.pollFirstEntry();
            }
            if(!map.isEmpty()){
                m1.put(q,map.firstEntry().getKey());
            }
        }
        int idx=0;
        for(int q: queriesClone){
            if(m1.containsKey(q)){
                ans[idx]= m1.get(q);    
            }else{
                ans[idx]=-1;
            }
            
            idx++;
        }
        return ans;
        
    }
}