class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length, i=0;
        while(i<n){
            if(intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
                i++;
            }else{
                break;
            }
        }
        while(i<n){
             if(intervals[i][0]<=newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                 newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }else{
                break;
            }
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            ans[j] = res.get(j);
        }
        return ans;
    }
}