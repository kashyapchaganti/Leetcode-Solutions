class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        int n1 = arr1.length, n2 =arr2.length;
        int i=0,j=0;
        while(i<n1 && j<n2){
            int v1 =Integer.parseInt(arr1[i]);
            int v2 =Integer.parseInt(arr2[j]);
            if(v1==v2){
                i++;
                j++;
            }else if(v1<v2){
                return -1;
            }else{
                return 1;
            }
        }
        while(i<n1){
            int v1 =Integer.parseInt(arr1[i]);
            if(v1!=0)return 1;
            i++;
        } 
        while(j<n2){
            int v2 =Integer.parseInt(arr2[j]);
            if(v2!=0)return -1;
            j++;
        } 
        return 0;
    }
}