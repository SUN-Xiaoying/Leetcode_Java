package dp;

import java.util.Arrays;

public class CoinChangeII {

    // ChatGPT
    // I'm so DAMN closed
    public static int mine(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; 
        for (int coin : coins) {
            // If i = coin, there is no duplicates
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }


    // Time Limit Exceeded, 22/28 testcases passed
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 1;
        }

        Arrays.sort(coins);
        
        int[][] dp= new int[coins.length][amount+1];

        return dfs(0, 0, dp, coins, amount);
    }

    private static int dfs(int i, int sum, int[][] dp, int[] coins, int amount){
        if(i == coins.length){
            return 0;
        }
        if(sum>amount || sum+coins[i]>amount){
            return 0;
        }
        if(sum==amount || sum+coins[i]==amount){
            return 1;
        }

        if(dp[i][sum] != 0){
            return dp[i][sum];
        }

        dp[i][sum] = dfs(i, sum+coins[i], dp, coins, amount) + dfs(i+1, sum, dp, coins, amount);
        return dp[i][sum];
    }



    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println(mine(amount, coins));
    }
}
