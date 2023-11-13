class Solution {
    public String sortVowels(String s2) {
        char[] arr = s2.toCharArray();
        // Arrays.sort(arr);
         List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        // Add all vowels to the HashSet at once
        HashSet<Character> s =new HashSet<>();
        s.addAll(vowelList);
        TreeSet<Pair> s1 =new TreeSet<>((a,b)-> a.r==b.r? a.c-b.c: a.r-b.r);
        int n = arr.length;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch= Character.toLowerCase(s2.charAt(i));
            if(s.contains(ch)){
                s1.add(new Pair(arr[i],i));
            }
        }
        // System.out.println(s1.toString());
        for(int i=0;i<n;i++){
            char ch= Character.toLowerCase(s2.charAt(i));
            if(s.contains(ch)){
                ans.append(s1.first().r);
                Pair x= s1.first();
                s1.remove(x);
            }else{
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }
    public class Pair{
        char r; int c;
        public Pair(char r, int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return r+" "+c;
        }
    }
}