// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         int n =s.length(),start=0;
//         int[] arr = new int[n];
//         int c=0;
//         boolean f =false;
//         for(int i=0;i<s.length();i++){
//             int b=s.charAt(i)-'a';
//             if(arr[b]!=0 ){
//                 if(s.charAt(start)!=s.charAt(i)){
//                     return false;
//                 }
//                 start++;
//             }else{
//                 arr[b]++;
//                 c++;
//             }
//         }
        
//        start++;
//         return (c==start)?true:false;
//     }
// }

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        if (t.substring(1, t.length() - 1).contains(s))
            return true;
        return false;
    }
}