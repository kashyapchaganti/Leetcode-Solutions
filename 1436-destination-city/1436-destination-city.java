class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> s = new HashSet<>();
        String ans="";
        for(List<String> x: paths){
            s.add(x.get(0));
        }
        for(List<String> x: paths){
            if(!s.contains(x.get(1))) return x.get(1);
            
        }
        return "";
    }
}