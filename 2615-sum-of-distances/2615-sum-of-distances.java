class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!m.containsKey(nums[i])){
                m.put(nums[i],new ArrayList<>());
            }
            m.get(nums[i]).add(i);
        }
        long[] ans = new long[n];
        for(Map.Entry<Integer,List<Integer>>e: m.entrySet()){
            List<Integer> arr = e.getValue();
            long[] psum=new long[arr.size()];
            psum[0]=arr.get(0);
            for(int i=1;i<psum.length;i++){
                psum[i]=psum[i-1]+arr.get(i);
            }
            for(int i=0;i<psum.length;i++){
                long l= i-1>=0 ? psum[i-1]:0;
                long r= psum[arr.size()-1]-psum[i];
                long x1= (long)(i)*(long)(arr.get(i))-l ;
                long x2=r-(long)(arr.get(i))*(long)((arr.size()-1-i));
                long x= x1+x2;
                // if(e.getKey()==1 && arr.get(i)==2) System.out.println(x1 +" "+x2 +" "+r);
                ans[arr.get(i)]=x;
                
            }
        }
        return ans;
    }
}

///  0 2 3 -> 2  