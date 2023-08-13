class Solution {
    public int minAbsoluteDifference(List<Integer> arr, int x) {
        int n = arr.size();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=arr.get(i);
        }
        TreeMap<Integer,Integer> m= new TreeMap<>();
        int s=0;
        int min =(int)(1e9);
        for(int i=x;i<n;i++){
            m.put(nums[s],m.getOrDefault(nums[s],0)+1);
            int x1=(int)(1e9),x2= (int)(1e9);
            if(m.ceilingKey(nums[i])!=null){
                int a = m.ceilingKey(nums[i]);
            x1= Math.abs(a-nums[i]);    
            }
            if(m.floorKey(nums[i])!=null){
                int a = m.floorKey(nums[i]);
            x2= Math.abs(a-nums[i]);    
            }
          
            min= Math.min(min, Math.min(x1,x2));
            s++;
        }
        return min;
    }
}