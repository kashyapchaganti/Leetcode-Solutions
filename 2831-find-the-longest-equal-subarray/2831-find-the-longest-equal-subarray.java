class Solution {
    public int longestEqualSubarray(List<Integer> arr, int k) {
        int n = arr.size();
        HashMap<Integer,List<Integer>> m= new HashMap<>();
        for(int i=0;i<n;i++){
            int v= arr.get(i);
            if(m.containsKey(v)){
                
            }else{
                m.put(v,new ArrayList<>());
            }
            m.get(v).add(i);
        }
        int min= 1;
        for(Map.Entry<Integer,List<Integer>>e:m.entrySet()){ // this is O(N) coz u r at max traversing only n elements 
            List<Integer> x= e.getValue();
            int s=0;
            
            for(int i=1;i<x.size();i++){
                int a =x.get(i)-x.get(s)+1;
                int tr = i-s+1;
                int k1 = a-tr;
                while(k1>k){
                    s++;
                    a =x.get(i)-x.get(s)+1;
                tr = i-s+1;
                k1 = a-tr;
                }
                min = Math.max(min,i-s+1);
            }
            }
        return min;
        
    }
}