package twopointer;

// https://leetcode.com/problems/sort-array-by-parity/description/
public class SortArrayByParity {
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public int[] sortArrayByParity(int[] nums) {
        int even =0;
        int odd = nums.length-1;

        while(even < odd){
            if(nums[even]%2 > nums[odd]%2){
                swap(nums, even, odd);
            }

            if((nums[even]%2) == 0) even++;
            if((nums[odd]%2) == 1) odd--;
        }

        return nums;
    }

    // wrong uqestion=

    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length;
        for(int even=0, odd=1; even<n && odd<n;){
            if((nums[n-1]%2) == 0){
                swap(nums, even, n-1);
                even+=2;
            } else {
                swap(nums, odd, n-1);
                odd+=2;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        
    }
}
