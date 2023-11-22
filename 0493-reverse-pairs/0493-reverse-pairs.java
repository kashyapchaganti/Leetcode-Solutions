class Solution {
    int n ;
    public int reversePairs(int[] nums) {
        n= nums.length;
        return mergesort(nums, 0, n-1);
    }
    public int mergesort(int[] nums , int l, int r){
        
        if(l==r) return 0;
        
        int m = l+(r-l)/2;
        int a = mergesort(nums, l,m);
        int b = mergesort(nums,m+1,r);
        int c= merge(nums, l, m, r);
        
        return a+b+c;
        
        
    }
    public int merge(int[] nums , int l, int m, int r){
        
        List<Integer> res = new ArrayList<>();
        int i =l, j = m+1;
        
        int count=0;
        while(i<=m && j<=r){   
            long v1= 2l*(long)nums[j];
            if(nums[i]>v1){
                count+=m-i+1;
                j++;
            }
            else{
                i++;
                
            }
        }
        i=l; j=m+1;
        
        while(i<=m && j<=r){
            if(nums[i]>nums[j]){
                res.add(nums[j]);
                j++;
            }
            else{
                res.add(nums[i]);
                i++;
                
            }
        }
        while(i<=m){
            res.add(nums[i++]);
        }
        while(j<=r){
            res.add(nums[j++]);
        }
        i=0;
        for(i=l;i<=r;i++){
            nums[i]= res.get(i-l);
        }
        
        return count;
        
    }
}