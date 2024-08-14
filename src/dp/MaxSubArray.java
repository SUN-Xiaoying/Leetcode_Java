package dp;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums={5,4,-1,7,8};
        int result = 23;
        System.out.println(maxSubArray(nums));
    }


    // 序列位置不能碰
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            currSum += nums[i];

            // 顺序搞错，负数报错
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }

        return maxSum;
    }
}
