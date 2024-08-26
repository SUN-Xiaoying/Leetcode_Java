package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {

    // ChatGPT 3ms Beats 99.14%
    // 什么是数组，下标可以做值用
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Mark each number present in the array
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // Mark the number at this index as negative to indicate the number has been seen
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
    
        // Collect all indices where the value is still positive
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
    
        return result;
    }

    // Brutal
    // 26ms Beats 5.23%
    public static List<Integer> mine(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();

        for(int i=1; i<=nums.length; i++){
            if(Arrays.binarySearch(nums, i)<0){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}
