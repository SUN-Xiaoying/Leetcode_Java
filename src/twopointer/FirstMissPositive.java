package twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissPositive {

    // 26ms Beats 5.42%
    // I'm so perfect
    public static int mine(int[] nums) {
        Arrays.sort(nums);

        int key=1;
        while(Arrays.binarySearch(nums, key)>=0){
            key++;
        }
        return key;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3,1,0,4,0};
        System.out.println(mine(nums));
    }
}
