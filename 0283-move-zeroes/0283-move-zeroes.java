class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
    int i=0, j=0;

    while(i<n && j<n){
      if(arr[i]==0){   
        j= findNonZero(arr,j, n);
        if(j==n) break;
        swap(i,j,arr);
        i++;
        j++;
      }else{
        while(i<n && arr[i]!=0){ 
              i++;
          } 
         j= findNonZero(arr,i+1, n);
      }

    }
    return ;
    }
      int findNonZero(int[] arr, int j, int n){

    while(j<n && arr[j]==0){
              j++;
     }
    return j;
  }
   void swap(int i, int j, int[] arr){
    int temp = arr[i];
    arr[i]= arr[j];
    arr[j]=temp;
  }
}