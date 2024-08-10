package book.dp;

public class MinCostTickets {

    public static int[] DURATION = {1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
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
