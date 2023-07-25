class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s=0, e= n-1;
        int ans=0;
        while(s<=e){
            int m = s+(e-s)/2;
            if(m-1>=0 && m+1<n && arr[m]>arr[m-1] && arr[m]<arr[m+1]){
                s=m+1;
            }else if(m-1>=0 && m+1<n && arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return m;
            }else if(m-1>=0 && m+1<n && arr[m]> arr[m+1] && arr[m]<arr[m-1]){
                e=m-1;
            }else if(m-1<0){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return -1;
    }
}