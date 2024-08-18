package trie;

// https://leetcode.com/problems/range-sum-query-immutable/description/
public class NumArray {
    public int[] sums;

    public NumArray(int[] nums) {
       sums = new int[nums.length+1];

        for(int i=1; i<nums.length+1; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}
