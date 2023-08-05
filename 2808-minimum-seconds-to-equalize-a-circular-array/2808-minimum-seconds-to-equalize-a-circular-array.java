class Solution {
    public int minimumSeconds(List<Integer> arr) {
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
        int min= (int)(1e9);
        for(Map.Entry<Integer,List<Integer>>e:m.entrySet()){
            List<Integer> x= e.getValue();
            int s=0;
            
            for(int i=0;i<x.size()-1;i++){
                int a = x.get(i+1)-x.get(i);
                a = a-1;
                if(a%2==0){
                    s= Math.max(s,a/2);
                }else{
                    a= (a/2)+1;
                    s= Math.max(a,s);
                }
                
            }
            int first = x.get(0)+n;
            int last = x.get(x.size()-1);
            int b= (first-last)-1;
            if(b%2==0){
                    s= Math.max(s,b/2);
                }else{
                    b= (b/2)+1;
                    s= Math.max(b,s);
                }
            // System.out.println(s +" "+e.getKey());
            min=Math.min(min,s);
            
        }
        return min;
    }
}