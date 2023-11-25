class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        
        int start = intervals[0][0], end = intervals[0][1];
        int i =1;
        List<Integer[]> arr= new ArrayList<>();
        while(i<n){
            if(intervals[i][0]<=end){
                end = Math.max(intervals[i][1], end); // 1, 6 
            }else {
                arr.add(new Integer[]{start, end});
                start = intervals[i][0];
                end =  intervals[i][1];
            }
            i++;
        }
        arr.add(new Integer[]{start, end});
        int[][] ans = new int[arr.size()][2];
        for(int j=0;j<arr.size();j++){
            ans[j][0]= arr.get(j)[0];
            ans[j][1]= arr.get(j)[1];
        }
        return ans;
    }
    
}