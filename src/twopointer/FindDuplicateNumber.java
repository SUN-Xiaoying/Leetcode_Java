package twopointer;

// https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length<2){
            return -1;
        }

        // Tortoise and Hare algorithm
        int fast = nums[nums[0]];
        int slow = nums[0];

        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while(fast != slow){
            fast=nums[fast];
            slow=nums[slow];
        }

        return slow;
    }

    public static void main(String[] args) {
        
    }
}
