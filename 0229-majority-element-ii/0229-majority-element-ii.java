class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1=0,ele1=Integer.MAX_VALUE, c2=0, ele2=Integer.MAX_VALUE;
        for(int x: nums){
            if(c1==0 && x!=ele2){
                c1++;
                ele1=x;
            }else if(c2==0 && x!=ele1){
                c2++;
                ele2=x;
            }else if(ele1==x){
                c1++;
            }else if(ele2==x){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        int a1=0, a2=0;
        for(int x: nums){
            if(x==ele1)a1++;
            if(x==ele2)a2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(a1>n/3)ans.add(ele1);
        if(a2>n/3)ans.add(ele2);
        return ans;
    }
}