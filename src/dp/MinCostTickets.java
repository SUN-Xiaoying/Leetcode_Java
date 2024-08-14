package dp;

import java.util.Arrays;

public class MinCostTickets {

    public static int[] DURATION = {1,7,30};
    public static int MAXN = 366;

    // 压缩空间，从底到顶
    public int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[MAXN];
        int n = days.length;

        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[n]=0;

        for(int i=n-1; i>=0; i--){
            for(int k=0, j=i; k<DURATION.length; k++){
                while(j<days.length && days[i]+DURATION[k] > days[j]){
                    j++;
                }
                dp[i] = Math.min(dp[i], dp[j]+costs[k]);
            }
        }
        return dp[0];
    }

    // 挂上缓存，从顶到底
    public int mincostTickets1(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        for(int i=0; i<days.length; i++){
            dp[i]=Integer.MAX_VALUE;
        }

        return recursion(days, costs, 0, dp);
    }
    // brutal >> cache
    public int recursion(int[] days, int[] costs, int i, int[] dp){
        
        if(i >= days.length){
            return 0;
        }

        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=0, j=i; k<3; k++){
            // Get min cost for index i
            while( j<days.length && (days[i]+DURATION[k]>days[j])){
                j++;
            }
            ans = Math.min(ans, costs[k]+ recursion(days, costs, j, dp));
        }
        dp[i]=ans;
        return ans;
    }
}
