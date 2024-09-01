package binarysearch.findcloest;

import java.util.Arrays;

// https://leetcode.com/problems/find-closest-number-to-zero/description/
public class FindCloestToZero {

    // Brutal
    // Think too much
    public static int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;
    
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closest) || (Math.abs(num) == Math.abs(closest) && num > closest)) {
                closest = num;  
            }
        }
        
        return closest; 
    }
    //179 / 227 testcases passed
    /*
     * 为什么总是差一点
    */
    public static int mine(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int l=0, r=n-1, mid=0;
        while(l<r){
            mid=l+((r-l)>>1);
            if(nums[mid] == 0){
                return nums[mid];
            }
            if(nums[mid]<0){
                l=mid+1;
            }else{
                r=mid;
            }
        }

        l=mid-1;
        r=mid;

        return Math.abs(nums[l])< Math.abs(nums[r]) ? nums[l] : nums[r];
    }

    public static void main(String[] args) {
        int[] nums= {-1,1,0,0};
        System.out.println(findClosestNumber(nums));
    }
}
