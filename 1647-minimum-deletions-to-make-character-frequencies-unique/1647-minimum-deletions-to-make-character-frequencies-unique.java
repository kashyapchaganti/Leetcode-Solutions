class Solution {
    public int minDeletions(String s) {
        int n =s.length();
        // int[] nums = new int[n];
        int[] m = new int[26];
        for(int i=0;i<n;i++){
            m[s.charAt(i)-'a']++;
        }
        Arrays.sort(m);
        int c=0;
        HashSet<Integer> s1 = new HashSet<>();
        for(int i=25;i>=0;i--){
            int count=m[i];
            int f=-1;
            if(count==0) break;
            while(s1.contains(count)){
                count--;
                f=0;
                c++;
            }
            if(count>0 || f==-1){
                s1.add(count);
            }
           
        }
        return c;
    }
}