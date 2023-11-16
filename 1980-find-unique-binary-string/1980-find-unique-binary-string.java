class Solution {
    HashSet<String> s ;
    List<String> res; 
    public String findDifferentBinaryString(String[] nums) {
        s= new HashSet<>();
        res= new ArrayList<>();
        for(String x: nums)s.add(x);
        int size = nums[0].length();
        check(size, new ArrayList<>());
        return res.size()==0? "": res.get(0);
    }
    
    
public void check(int n , List<Character> x){

	if(x.size()==n){
		StringBuilder sb = new StringBuilder();
		for(char ch: x){
			sb.append(ch);
		}
		if(!s.contains(sb.toString())){
			res.add(sb.toString());
			return ;
        }
        return ;
	}
	
	x.add('1');
	check(n, x);
	x.remove(x.size()-1);
	x.add('0');
    check(n,x);
	x.remove(x.size()-1);

}

}