class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rb=0; int re= matrix.length-1; int cb= 0; int ce= matrix[0].length-1;
        while(rb<=re && cb<=ce){
            //move right 
            
            for(int i=cb; i<=ce;i++){
                res.add(matrix[rb][i]);
            }
            rb++; // 1, 2, 0,2
            //move down
            for(int i=rb;i<=re;i++){
                res.add(matrix[i][ce]);
            }
            ce--; // 1, 2, 0,1
            // move left 
            if(rb<=re){
                for(int i=ce;i>=cb;i--){
                    res.add(matrix[re][i]);
                }
                
            }
            re--; // 1, 1, 0,1
            //move top 
            if(cb<=ce){
                for(int i=re;i>=rb;i--){
                    res.add(matrix[i][cb]);
                }
                
            }cb++;
        }
        return res;
    }
}