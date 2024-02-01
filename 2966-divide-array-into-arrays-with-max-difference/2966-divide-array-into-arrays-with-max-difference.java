class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length,i=0;
        List<int[]> arr= new ArrayList<>();
        
        int[][] a2=new int[0][0];
        while(i<n){
            int c=0;
            int [] a= new int[3];
            int j=0;
            int f=0;
            while(i<n-1 && c<2){
                if(nums[i+1]-nums[i]<=k){
                    a[j++]=nums[i];
                    i++;
                }else{
                    f=-1;
                    break;
                }
                c++;
            }
            if(f==-1) return a2;
            if(i<n){
                a[j++]=nums[i];
                arr.add(new int[]{a[0],a[1],a[2]});
                if(a[2]-a[0]>k)return a2;
                i++;
            }
        }
        int[][] ans = new int[arr.size()][3];
        int idx=0;
        for(int[] x: arr){
            ans[idx][0]=x[0];
            ans[idx][1]=x[1];
            ans[idx][2]=x[2];
            idx++;
        }
        return ans;
    }
}