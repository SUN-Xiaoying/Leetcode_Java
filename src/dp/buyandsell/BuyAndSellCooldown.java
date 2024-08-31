package dp.buyandsell;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuyAndSellCooldown {


        // https://www.youtube.com/watch?v=I7j0F7AHpb8
        // 1ms Beats 84.08%

        public int maxProfitCoolDown(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            // 0==buy, 1==sell

            return dfs(prices, 0, 0, dp);
        }

        

        public int dfs(int[] prices, int i, int j, int[][]dp){
            if(i>=prices.length){
                return 0;
            }

            if(dp[i][j] != 0){
                return dp[i][j];
            }

            int buy=0, sell=0, cooldown=0;
            if(j==0){
                buy = dfs(prices, i+1, 1, dp) - prices[i];
                cooldown = dfs(prices, i+1, 0, dp);

                dp[i][j] = Math.max(cooldown, buy);
            } else {
                sell = dfs(prices, i+2, 0, dp) + prices[i];
                cooldown = dfs(prices, i+1, 1, dp);

                dp[i][j] = Math.max(cooldown, sell);
            }

            return dp[i][j];
        }
}
