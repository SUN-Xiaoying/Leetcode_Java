package array.maxsubarray;


/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * ZUO: https://www.youtube.com/watch?v=8Vxr8L2-syw&list=PLvKfL6GtwDxwuyrpAJfU3HTnPZl4WnraE&index=70
 */
public class MaxSubArray {

    // Runtime: 1ms Beats 99.45%
    // Mem: 56.99MB Beats 57.01%
    public static int maxSubArray2(int[] nums) {
        /*
        * 空间压缩, space compression
        */
        int n = nums.length, max_sum= nums[0];
        if(n==1){return nums[0];}
        for(int i=1, pre = nums[0]; i<n; i++){
            pre = nums[i] + Math.max(0, pre);
            max_sum = Math.max(max_sum, pre);
        }

        return max_sum;
    }
    
    // 1ms Beats 99.45%
    public static int maxSubArray1(int[] nums) {
        /*
         * Subarray has to be continuous 
         */
        int n = nums.length, max_sum= nums[0];
        if(n==1){return nums[0];}
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1; i<n; i++){
            dp[i] = nums[i] + Math.max(0, dp[i-1]);
            max_sum = Math.max(max_sum, dp[i]);
        }

        return max_sum;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubArray(nums));
    }


    public static int maxSubArray3(int[] nums) {
        /*
        * 空间压缩, space compression
        */
        int n = nums.length, max_sum= nums[0];
        int l=0, r=0;
        if(n==1){return nums[0];}
        for(int i=1, pre = nums[0]; i<n; i++){
            pre = nums[i] + Math.max(0, pre);
            max_sum = Math.max(max_sum, pre);
        }

        return max_sum;
    }
}