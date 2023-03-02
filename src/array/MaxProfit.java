package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                maxProfit += temp;
            }
        }

        return maxProfit;
    }

    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            s.add(num);
        }

        int i = 0;
        int[] temps = new int[s.size()];
        /*
         Two for, not cool
        * */
        for (int temp : s) {
            temps[i] = temp;
            i++;
        }
        i = 0;
        Arrays.sort(temps);
        for (int num : temps) {
            nums[i] = num;
            i++;
        }

        return s.size();
    }

    public static int maxProfit11(int[] prices) {
        int result = 0;
        int largest = -1;

        for (int j = prices.length - 1; j > 0; j--) {
            int i = 0;
            while (i < j) {
                int temp = prices[j] - prices[i];
                if (temp > 0) {
                    result = Math.max(result, temp);
                }
                i++;
            }
        /* Time Limit Exceeded:
            差价找最大
        */
            if (prices[j] < largest) {
                return result;
            } else {
                largest = prices[j];
            }
        }
        return result;
    }
}
