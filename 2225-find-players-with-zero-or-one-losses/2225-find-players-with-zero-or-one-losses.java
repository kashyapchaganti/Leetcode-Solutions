class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int max=0;
        for(int[] match: matches){
            max = Math.max(max,Math.max(match[0],match[1]));
        }
        int[][] results = new int[max+1][2]; // [win][lose]
        List<List<Integer>> output = new ArrayList<>();
        for(int[] x: matches){
            int winner = x[0];
            int loser = x[1];
            results[winner][0]++;
            results[loser][1]++;
        }
        List<Integer> winnersList = new ArrayList<>();
        List<Integer> losersList = new ArrayList<>();
        for(int i=0; i<=max;i++){
            if(results[i][1]==1)losersList.add(i);
            if(results[i][1]==0 && results[i][0]>0)winnersList.add(i);
        }
        
        output.add(winnersList);
        output.add(losersList);
        return output;
        
    }
}

//  1 , 2 ,  4 
//  3, 6 , 7, 5, 8 