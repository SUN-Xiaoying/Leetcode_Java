package google;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BuyAndSell {



    // 2ms Beats 70.95%
    public int maxProfit_SlidingWindow(int[] prices) {
        int ans = 0;
        for(int l=0, r=1; r<prices.length; ){
            if(prices[l]>=prices[r]){
                l=r;
                r=l+1;
            } else {
                ans = Math.max(ans, prices[r++]-prices[l]);
            }
        }

        return ans;
    }

    // 203 / 212 testcases passed
    // GREAT, First shot
    public int maxProfitMine(int[] prices) {
        int ans=0, temp=0;
        for(int i=0; i<prices.length; i++){
            temp = findMax(prices, i+1) - prices[i];
            if(temp<=0){
                continue;
            } else {
                ans = ans > temp? ans : temp;
            }
        }

        return ans;
    }

    public int findMax(int[] prices, int k){
        int ans = 0;
        for(int i=k; i<prices.length; i++){
            ans = prices[i]>ans ? prices[i] : ans;
        }

        return ans;
    }
}
