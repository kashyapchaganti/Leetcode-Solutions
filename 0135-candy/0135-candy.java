class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                ans[i]= ans[i-1]+1;
            }
        }
        // System.out.println(Arrays.toString(ans));
        int sum=ans[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                ans[i]= Math.max(1+ans[i+1],ans[i]);
            }
            sum+=ans[i];
        }
        // System.out.println(Arrays.toString(ans));
        return sum;
    }
}