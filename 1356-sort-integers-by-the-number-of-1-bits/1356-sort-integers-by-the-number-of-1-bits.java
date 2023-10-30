class Solution {
    public int[] sortByBits(int[] arr) {
        int n =arr.length;
        int[] ans =new int[n];
        List<Pair> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x= arr[i];
            int c=0;
            while(x>0){
                if((x & 1)==1){
                    c++;
                }
                x=x>>1;
            }
            a.add(new Pair(c,arr[i]));
        }
        Collections.sort(a,(a1,b)-> a1.r==b.r? a1.c-b.c: a1.r-b.r);
        for(int i=0;i<n;i++){
            ans[i]=a.get(i).c;
        }
        return ans;
    }

}
class Pair{
    int r,c;
    public Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}