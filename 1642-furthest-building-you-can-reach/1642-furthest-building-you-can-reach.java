class Solution {
    int n ;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        n = heights.length;
        int s= 0, e= n-1;
        List<int[]> sortedClimbs = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int climb= heights[i+1]-heights[i];
            if(climb>0){
                sortedClimbs.add(new int[]{climb, i+1});
            }
        }
        Collections.sort(sortedClimbs, (a,b)-> a[0]-b[0]);
        int ans=0;
        while(s<=e){
            int m = s+(e-s)/2;
            if(check(sortedClimbs, bricks, ladders,m)){
                ans=m;
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return ans;
    }
    public boolean check(List<int[]> h, int b, int l, int m){
        int s=0;
        for(int[] a: h){
            if(a[1]>m) continue;
            if(a[0]<=b){
                b-=a[0];
            }else if(l>0){
                l--;
            }else{
                return false;
            }
        }
        return true;
    }
}

