package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,3,3,4,3,2,4,2};
//        int[] nums1 = {1,2,3,4};
//        System.out.println(containsDuplicate(nums1));

        int[] input = {4,1,2,1,2};
        System.out.println(singleNumber(input));

    }
    public static boolean containsDuplicate(int[] nums) {
        /*
            除重上哈希
        */
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        return nums.length > set.size() ;
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }
}
