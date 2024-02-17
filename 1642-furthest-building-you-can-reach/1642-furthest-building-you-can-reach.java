class Solution {
    public int furthestBuilding(int[] nums, int b, int l) {
        int n = nums.length;
        List<Pair> arr = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                arr.add(new Pair(nums[i+1]-nums[i],i+1));
            }
        }
        Collections.sort(arr, (a,b1)-> a.r==b1.r? a.c-b1.c: a.r-b1.r);
        int s = 0, e= n-1, ans=0;
        while(s<=e){
            int m = s+(e-s)/2;
            if(check(m,l,b,arr)){
                ans = m;
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return ans;
    }
    public boolean check(int m, int l, int b,List<Pair> arr ){
        for(Pair x: arr){
            if(x.c<=m){
                if(b>=x.r){
                    b-=x.r;
                }else{
                    if(l>0){
                        l--;
                    }else{
                        return false;
                    }
                }
            }else{
                continue;
            }
        }
        return true;
    }
}
class Pair{
    int r,c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

/*
4,1,1,1,99999

1, 1, 1 ,1 , 4 , x 

4
1

*/