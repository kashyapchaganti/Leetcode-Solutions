class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int z=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                z++;
            }else{
                int v= arr[i];
                arr[i]=0;
                arr[i-z]=v;
                // arr[i]=0;
                
            }
        }
        return ;

    
  }
   void swap(int i, int j, int[] arr){
    int temp = arr[i];
    arr[i]= arr[j];
    arr[j]=temp;
  }
}

// [1,2,0,3]