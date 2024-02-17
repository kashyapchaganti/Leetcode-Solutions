class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int max =0, start=0;
        
        int[] psum =new int[n];
        psum[0]= grumpy[0]==0?customers[0]:0;
        int[]totalSum = new int[n];
        totalSum[0]= customers[0];
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        for(int i=1;i<n;i++){
            int val =grumpy[i]==0?customers[i]:0;
            psum[i]= psum[i-1]+val;
            totalSum[i]= totalSum[i-1]+customers[i];
        }
        for(int i=0;i+minutes-1<n;i++){
            int commonzeros =i-1>=0?psum[i+minutes-1]-psum[i-1]:psum[i+minutes-1];
            int sumCur = i-1>=0?totalSum[i+minutes-1]-totalSum[i-1]:totalSum[i+minutes-1];
            // System.out.println(commonzeros+" "+sumCur);
            max = Math.max(sumCur+psum[n-1]-commonzeros, max);
            
        }
        return max;

    }
}

/*
[4,10,10]
[1,1,0]
2



*/