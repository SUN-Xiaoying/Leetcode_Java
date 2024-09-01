package dp.longestlength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubsequenceofTarget {

    // ChatGPT, use int[][] dp
    // 266ms Beats 43.55%
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        int[][] dp = new int[nums.size()][target];

        int result = dfs(0, 0, 0, dp, nums, target);
        return result==Integer.MIN_VALUE ? -1 : result;
    }

    private int dfs(int i, int sum, int length, int[][] dp, List<Integer> nums, int target){
        if(sum == target){
            return length;
        }

        if(sum > target || i>=nums.size()){
            return Integer.MIN_VALUE;
        }

        if (dp[i][sum] != 0) {
            return dp[i][sum];  
        }

        int include = dfs(i+1, sum+nums.get(i), length+1, dp, nums, target);
        int exclude = dfs(i+1, sum, length, dp, nums, target);

        dp[i][sum] = Math.max(include, exclude);
        return dp[i][sum];
    }

    public static int mine(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] =1;
        
        return mine_dfs(0,0,dp, nums, target);
    }

    private static int mine_dfs(int i, int sum, int[] dp, List<Integer> nums, int target){
        if (sum > target) {
            return 0;  
        }
        
        if (sum == target) {
            return 1;  
        }
    
        if(i>=nums.size()){
            return 0;
        }

        if (dp[sum] != -1) {
            return dp[sum];  
        }

        dp[sum] += Math.max(mine_dfs(i, sum+nums.get(i), dp, nums, target), mine_dfs(i+1, sum, dp, nums, target));
        return dp[sum];
    }

    public static void main(String[] args) {
         List<Integer> nums = new ArrayList<Integer>();
         nums.add(1);
         nums.add(2);
         nums.add(3);
         nums.add(4);
         nums.add(5);
        int target = 9;

        System.out.println(mine(nums, target));
    }
}
