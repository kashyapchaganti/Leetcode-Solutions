class Solution {
    public boolean validMountainArray(int[] arr) {
        int n =arr.length;
        int max = Integer.MAX_VALUE;
        int peak =-1;
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                if(max==Integer.MAX_VALUE){
                    max = arr[i];
                    peak =i;
                    break;
                }
            }else if(arr[i]==arr[i-1] || arr[i]==arr[i+1]) return false;
            else if(arr[i] <arr[i-1] || arr[i]>arr[i+1]) return false;
        }
        if(peak==-1)return false;
        
        for(int i=peak+1;i<n;i++){
            if(arr[i]==arr[i-1] ) return false;
            if(arr[i]>arr[i-1]) return false;
        }
        return true;
    }
}