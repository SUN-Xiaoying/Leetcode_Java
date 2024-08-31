package dp.buyandsell;

public class BuyAndSell2 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    // 1ms Beats 90.12%
    // First shot, EASY
    public int maxProfit2(int[] prices) {
        int sum=0;
        for(int i=0; i<prices.length-1; i++){
            sum += Math.max(0, prices[i+1]-prices[i]);
        }

        return sum;
    }

}
