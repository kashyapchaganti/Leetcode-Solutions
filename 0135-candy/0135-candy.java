class Solution {
    public int candy(int[] ratings) {
int[] res = new int[ratings.length];
  Arrays.fill(res, 1);
  int count = 0;
  
	//left pass
  for(int i = 1; i < ratings.length; i++){
  	if(ratings[i] > ratings[i - 1]){
    	res[i] = res[i - 1] + 1;
    }
  }
  
  count = res[ratings.length - 1];
  //right pass
  for(int i = ratings.length - 2; i >= 0; i--){
  	if(ratings[i + 1] < ratings[i] && res[i] <= res[i + 1]){
    	res[i] = res[i + 1] + 1;
    }
    count += res[i];
  }
  
  return count;
    }
}