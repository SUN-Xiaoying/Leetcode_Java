package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations/description/
public class Permutations {


    // Back Track
    // 2ms Beats 42.28%
    public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if(n==0){
            result.add(new ArrayList<>(n));
            return result;
        }

        int head = nums[0];
        int[] rest = Arrays.copyOfRange(nums, 1, n);
        List<List<Integer>> perms = permute(rest);
        

        for(List<Integer> perm: perms){
            for(int i=0; i<=perm.size(); i++){
                List<Integer> newPerm = new ArrayList<>(perm);  // Create a new copy of perm
                newPerm.add(i, head);  // Add the head element at position i
                result.add(newPerm);  // Add the new permutation to the result
            }
        } 

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> perms = permute(nums);

        for(List<Integer> perm: perms){
            perm.stream().forEach(i -> System.out.print(i));
        }
    }


}
