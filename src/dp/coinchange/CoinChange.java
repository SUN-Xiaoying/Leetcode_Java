package dp.coinchange;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {

    // 17ms Beats 49.61%
    // DP
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(i-coin<0){
                    break;
                }
                if(dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]); 
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // Greedy, Wrong Answer, 51 / 189 testcases passed
 

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;

        System.out.println(coinChange(coins, amount));
    }
}
