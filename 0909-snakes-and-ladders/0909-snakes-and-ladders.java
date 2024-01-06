class Pair{
    int idx;
    int t;
    public Pair(int idx,int t){
        this.idx=idx;
        this.t=t;
    }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-1);
        int n = board.length;
        int f = 1;
        int k = 1;
        int[] dis= new int[(n*n)+1];
        for(int i=n-1;i>=0;i--){
            if(f==1){
                for(int j=0;j<n;j++){
                    if(board[i][j]!=-1){
                        arr.add(board[i][j]);
                    }else{
                        arr.add(k);
                    }
                    k++;
                }
                f=0;
            }else{
                for(int j=n-1;j>=0;j--){
                    if(board[i][j]!=-1){
                        arr.add(board[i][j]);
                    }else{
                        arr.add(k);
                    }
                    k++;
                }
                f=1;
            }
        }
        
        Arrays.fill(dis,(int)(1e9));
        dis[1]=0;
        
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(1,0));        
        while(!pq.isEmpty()){
            Pair cur= pq.poll();
            for(int i=1;i<=6;i++){
                int x= cur.idx+i;
                if(x<arr.size() && arr.get(x)<dis[arr.get(x)]){
                    dis[arr.get(x)]=cur.t+1;
                    pq.add(new Pair(arr.get(x),cur.t+1));
                }
            }
        }
        return dis[n*n]>=(int)(1e9)?-1:dis[n*n];
    }
    
}