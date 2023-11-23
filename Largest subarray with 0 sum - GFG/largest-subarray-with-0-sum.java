//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int sum=0;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);
        int max=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(m.containsKey(sum)){
                max= Math.max(max, i-m.get(sum));
                // System.out.println(i+" "+m.get(sum));
            }else{
                m.put(sum,i);
            }
        }
        return max;
    }
}