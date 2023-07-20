class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        
        for(int i=0;i<n;i++){
            if(!s.isEmpty()){
                boolean f= false;
                while(!s.isEmpty()){
                
                int a =s.peek();
                int x= nums[i];
                if( x<0 && a>0){
                    int y = Math.abs(x);
                    int b = Math.abs(a);
                    if(y>b){
                        f=true;
                        s.pop();
                    }else if(y<b){
                        f=false;
                        break;
                    }else{
                        s.pop();
                        f=false;
                        break;
                    }
                }else{
                    s.push(x);
                    f=false;
                    break;
                }
                
            }
                if(f){
                    s.push(nums[i]);
                }
                
            
            } else{
                s.push(nums[i]);
            }
            
        }
        int[] ans = new int[s.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]= s.pop();
        }
        return ans;
        
    }
}