class Solution {
    int n;
    public List<String> letterCombinations(String digits) {
        String[]arr= {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        n= digits.length();
        if(n==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        
        check(res,new ArrayList<>(),arr,digits, 0);
        return res;
    }
    public void check(List<String>res, List<Character>x, String[] arr, String s, int i){
        if(i==n){
            StringBuilder y= new StringBuilder();
            for(char z1:x){
                y.append(z1);
            }
            
            res.add(y.toString());
            return;
        }
        
        
            int num= s.charAt(i)-'0';    
            String s1= arr[num-1];
            // System.out.println(s1);
            for(int j=0;j<s1.length();j++){
                x.add(s1.charAt(j));
                check(res,x,arr,s,i+1);
                x.remove(x.size()-1);
            }
        
        return ;
    }
}