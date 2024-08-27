package binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        long l=0;
        long r=Arrays.stream(nums).sum();
        long ans=0;
        while(l<=r){
            long mid=l+((r-l)>>1);
            if(f(nums, mid) <=  k){
                ans=mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return (int)ans;
    }

    public int f(int[] nums, long target){
        int part=1, sum=0;
        for(int num: nums){
            if(num>target){
                return Integer.MAX_VALUE;
            } 
            if(sum+num> target){
                part++;
                sum=num;
            } else {
                sum+=num;
            }
        }
        return part;
    }

}
