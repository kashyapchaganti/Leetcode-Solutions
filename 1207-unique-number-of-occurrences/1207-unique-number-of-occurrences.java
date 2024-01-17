class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n =arr.length;
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int x:arr) m.put(x,m.getOrDefault(x,0)+1);
        HashSet<Integer> s=new HashSet<>();
        for(int k: m.keySet()){
            if(s.contains(m.get(k))) return false;
            s.add(m.get(k));
        }
        return true;
    }
}

/*
    1: 3
    2: 2
    3: 1

*/