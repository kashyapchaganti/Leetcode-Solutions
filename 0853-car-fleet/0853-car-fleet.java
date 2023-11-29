class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[][] nums = new double[n][3];
        for(int i=0;i<n;i++){
            nums[i][0]= position[i];
            nums[i][1]= speed[i];
            nums[i][2]=(double)(target-position[i])/(double)speed[i];
        }
        Arrays.sort(nums, (a,b)-> Double.compare(a[0],b[0]));
        for(double[] x: nums){
            System.out.println(Arrays.toString(x));
        }
        Stack<Double> st = new Stack();
        for(int i=n-1;i>=0;i--){
            double max = nums[i][2];
            if(!st.isEmpty() && st.peek()>=nums[i][2]){
                max= Math.max(st.pop(),max);
            }
            st.push(max);
        }
        return st.size();
    }
}