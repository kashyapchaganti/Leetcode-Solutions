class Pair{
    int num;
    int c;
    public Pair(int num, int c){
        this.num=num;
        this.c=c;
    }
}
class Solution {
    public long minCost(int[] nums, int[] cost) { // distribute and find the median [1,2,3,5]- > [1,1,2,2,2,2,...,3,3,3,5]
        int n = nums.length;
        List<Pair> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Pair(nums[i],cost[i]));
        }
        Collections.sort(arr,(a,b)-> a.num-b.num);
        long s=0;
        for(Pair x: arr){ s+=x.c;}
        int j=0;
        long t=0;
        int median=0;
        while(t<(s+1)/2 && j<n){
            t+=arr.get(j).c;
            median=arr.get(j++).num;
        }
        //System.out.println(median);
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(1L*nums[i]-1L*median)*1l*(cost[i]);
        }
        return ans;
    }
}