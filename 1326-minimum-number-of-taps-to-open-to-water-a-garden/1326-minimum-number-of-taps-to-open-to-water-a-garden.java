// import java.util.Arrays;

public class Solution {
    private int[] dp;
    private int[] r;
    private final int INF = 1000000000; // Equivalent to 1e9 in C++

    public int solve(int pos) {
        int ans = INF;
        if (pos <= 0) return 0;
        if (dp[pos] != -1) return dp[pos];
        for (int i = pos - 1; i >= Math.max(pos - 100, 0); i--) {
            if (pos <= (i + r[i])) {
                ans = Math.min(ans, solve(i - r[i]) + 1);
            }
        }
        if (r[pos] > 0) {
            ans = Math.min(ans, solve(pos - r[pos]) + 1);
        }
        return dp[pos] = ans;
    }

    public int minTaps(int n, int[] ranges) {
        dp = new int[10003];
        Arrays.fill(dp, -1);
        r = ranges;
        int ans = solve(n);
        if (ans >= INF) {
            return -1;
        }
        return ans;
    }

    
}
