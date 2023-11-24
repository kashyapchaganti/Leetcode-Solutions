class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1= num1.length()-1, n2= num2.length()-1;
        int carry=0;
        while(n1>=0 || n2>=0){
            int a=0,b=0;
            if(n1>=0){
                a=(int)(num1.charAt(n1)-'0');
                n1--;
            }
            if(n2>=0){
                b=(int)(num2.charAt(n2)-'0');
                n2--;
            }
            
            int sum = a+b+carry;
            int val= sum%10;
            carry=sum/10;
            sb.append(val);
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}