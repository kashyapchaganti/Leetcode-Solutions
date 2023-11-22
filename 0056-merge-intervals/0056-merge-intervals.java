class Solution {
    public int[][] merge(int[][] matrix) {
        int n =matrix.length;
        Arrays.sort(matrix,(a,b)-> a[0]==b[0]? a[1]-b[1]:a[0]-b[0]);
        
        int left = matrix[0][0], right= matrix[0][1];
        List<Pair> arr= new ArrayList<>();
        for(int i=1;i<n;i++){
            int[] cur = matrix[i];
            if(right>=cur[0]){
                right = Math.max(cur[1],right);
            }else{
                arr.add(new Pair(left,right));
                left= cur[0]; right= cur[1];
            }
        }
        arr.add(new Pair(left,right));
        int[][] ans = new int[arr.size()][2];
        int idx=0;
        for(Pair cur: arr){
            ans[idx][0]= cur.start;
            ans[idx][1]= cur.end;
            idx++;
        }
        return ans;
        
    }
}
class Pair{
    int start, end;
    public Pair(int start , int end ){
        this.start =start; 
        this.end=end;
    }
}
/*
  [1, 3], [2,6], [8,10], [15,18]
  sort 
  [1, 6] , [8,10], [15,18]
  
  [1,3], [2,6], [5,10], [9,18]
  [1,18]

*/