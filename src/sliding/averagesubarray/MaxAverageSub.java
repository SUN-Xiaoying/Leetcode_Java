package sliding.averagesubarray;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaxAverageSub {
    // https://www.youtube.com/watch?v=UdUUnoiLkPg
    // You don't have to lose currentSum
    // 4ms Beats 69.04%
    public static double findMaxAverage(int[] nums, int k) {
        double max_sum = - Double.MAX_VALUE;
        double sum = 0.0;
        for(int i=0; i<k; i++){
            sum += (double) nums[i];
        }
        max_sum = Math.max(sum, max_sum);

        for(int l=0, r=k; r<nums.length; l++, r++){
            sum = sum - nums[l] + nums[r];
            max_sum = Math.max(sum, max_sum);
        }

        return max_sum/(double)k;
    }
    
    // Time Limit Exceeded
    // 117 / 127 testcases passed
    public double mine(int[] nums, int k) {
        // CAREFUL!
        double sum = - Double.MAX_VALUE;
        if(nums.length == k){
            sum = Arrays.stream(nums).sum();
            return sum/(double)k;
        }
        int[] subArray = new int[k];
        
        for(int i=0; i<=nums.length-k; i++){
            subArray = Arrays.copyOfRange(nums, i, i+k);
            sum = Math.max(sum, Arrays.stream(subArray).sum());
        }

        return sum/(double)k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
