class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int a = Math.abs(sx-fx);
        int b = Math.abs(sy-fy);
        if(a>b){
            int d= a;
            a=b;
            b=d;
        }
        if(a==0 && b==0){
            if(t!=1){
                return true;
            }else{
                return false;
            }
        }
        int d = b-a;
        int c=d+a;
        // System.out.println(c);
        return c<=t;
    }
}