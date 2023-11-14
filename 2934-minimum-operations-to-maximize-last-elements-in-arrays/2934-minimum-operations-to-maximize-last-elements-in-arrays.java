class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int a = nums1[n-1] , b=nums2[n-1];
        int f1=0,f2=0,c1=0,c2=1;
        for(int i=0;i<n-1;i++){
            if(nums1[i]<=a && nums2[i]<=b){
                continue;
            }else if(nums2[i]<=a && nums1[i]<=b){
                c1++;
            }else{
                f1=1;
                break;
            }
        }
        for(int i=0;i<n-1;i++){
            if(nums1[i]<=b && nums2[i]<=a){
                continue;
            }else if(nums2[i]<=b && nums1[i]<=a){
                c2++;
            }else{
                f2=1;
                break;
            }
        }
        if(f1==1 && f2==1) return -1;
        if(f1==0 && f2==0) return Math.min(c1,c2);
        if(f1==0) return c1;
        return c2;
        
    }
}