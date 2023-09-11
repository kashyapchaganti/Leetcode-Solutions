class Solution {
    public List<List<Integer>> groupThePeople(int[] groups) {
        int n = groups.length;
        Pair[] nums =new Pair[n];
        for(int i=0;i<n;i++){
            nums[i]= new Pair(groups[i],i);
        }
        Arrays.sort(nums,(a,b)-> a.r==b.r? a.c-b.c: a.r-b.r);
        List<List<Integer>> ans = new ArrayList<>();
        int f=0;
        int i=0;
        while(i<n){
            List<Integer> x =new ArrayList<>();
            f=0;
            while(f==0 && i<n){
                if(nums[i].r>x.size()){
                    x.add(nums[i].c);    
                }
                if(nums[i].r==x.size()){
                    i++;
                    ans.add(new ArrayList<>(x));
                    f=1;
                    break;
                }
                i++;
            }
        }
        return ans;
        
    }
}
class Pair{
    int r,c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}