class Solution {
    public int minimumLength(String s) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        int idx=0;
        for(char ch: s.toCharArray()){
            if(ch=='a'){
                a.add(idx);
            }else if(ch=='b'){
                b.add(idx);
            }else{
                c.add(idx);
            }
            idx++;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        int i=0, j= s.length()-1;
        while(i<j){
            System.out.println("1 " + i +" "+j);
            if(s.charAt(i)==s.charAt(j)){
                char ch = s.charAt(i);
                List<Integer> arr;
                if(ch=='a'){
                    arr = a;
                }else if(ch=='b'){
                    arr=b;
                }else arr= c;
                int e1 = check(i,0,arr);
                int e2 = check(j,1,arr);
                i=e1+1;
                j=e2-1;
                System.out.println("2 " + i +" "+j);
            }else{
                return j-i+1;
            }
        }
        if(j<i) return 0;
        return j-i+1;
        
    }
    public int check(int i, int flag, List<Integer> arr){
        if(flag==0){
            int index = bs(i,arr);
            System.out.println(index+" BS "+ flag +" "+i);
            int ans =index;
            for(int j= index;j<arr.size()-1;j++){
                if(arr.get(j+1)-arr.get(j)==1){
                    ans= j+1;
                    continue;
                }else{
                    System.out.println(index +" "+ans +" FLAG- INSIDE "+flag);
                    return arr.get(j);
                }
            }
            System.out.println(index +" "+ans +" FLAG "+flag);
            return arr.get(ans);
            
            
            
        }else{
            
            int index = bs(i,arr);
            System.out.println(index+" BS "+ flag +" "+i);
            int ans =index;
            for(int j= index;j>0;j--){
                if(arr.get(j)-arr.get(j-1)==1){
                    ans= j-1;
                    continue;
                }else{
                    System.out.println(index +" "+ans +" FLAG- INSIDE "+flag);
                    return arr.get(j);
                }
            }
            
            System.out.println(index +" "+ans +" FLAG "+flag);
            return arr.get(ans);
        }
    }
    public int bs(int i, List<Integer> arr){
        int s = 0, e = arr.size()-1, ans=0;
            while(s<=e){
                int m = s+(e-s)/2;
                if(arr.get(m)==i){
                    ans = m;
                    break;
                }else if(arr.get(m)>i){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }
        // System.out.println(arr +" INSIDE BS "+ans +" "+i);
        return ans;
    }
    
}

/*
0 1 2 3 4 5 6
a a b c c b a

a: [0, 1, 6] 
b: [2,5]
c: [3,4]



*/