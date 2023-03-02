package dynamic;

import java.util.Arrays;

public class BestBuyAndSell {
    public int maxProfit(int[] prices) {
        // 序列位置不能碰
        int least = Integer.MAX_VALUE;
        int result = 0;

        for(int i=0; i< prices.length; i++){
            least = Math.min(prices[i], least);
            result = Math.max(result, prices[i]-least);
        }

        return result;
    }
}
