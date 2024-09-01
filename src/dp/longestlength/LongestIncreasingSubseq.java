package dp.longestlength;

import java.util.Arrays;

public class LongestIncreasingSubseq {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  

        int maxLength = 1;  

        for (int i = 1; i < n; i++) {  
            for (int j = 0; j < i; j++) {  
                if (nums[i] > nums[j]) {  
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    // 27 / 55 testcases passed
    // Give me that BIGGER that BETTER
    public static int mine(int[] nums) {
        int n = nums.length, length=0;
        if(n<=1){
            return n;
        }
        int[] dp = new int[n];

        for(int i=n-1; i>0; i--){
            length = Math.max(length, getLength(i, Integer.MAX_VALUE, dp, nums));
        }
        
        return length;
    }

    private static int getLength(int i, int prev, int[] dp, int[] nums){
        if(i==0){
            return nums[0]<prev ? 1 : 0;
        }

        if(dp[i]!=0){
            return dp[i];
        }

        if(nums[i] < prev){
            int include = getLength(i-1, nums[i], dp, nums)+1;
            int exclude = getLength(i-1, prev, dp, nums);
            dp[i] = Math.max(exclude, include);
        }
        
        return dp[i];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};

        System.out.println(lengthOfLIS(nums));
    }
}
