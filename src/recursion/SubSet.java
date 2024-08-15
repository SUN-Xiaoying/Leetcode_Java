package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subsets/description/
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(nums, 0, temp, sets);

        List<List<Integer>> result = new ArrayList<>(sets);

        return result;
    }

    private void subsetsHelper(int[] nums, int i, List<Integer> temp, Set<List<Integer>> sets){
        if(i == nums.length){
            sets.add(new ArrayList<>(temp));
            return;
        } else {
            temp.add(nums[i]);
            subsetsHelper(nums, i+1, temp, sets);
            temp.remove(temp.size() - 1);
            subsetsHelper(nums, i+1, temp, sets);
        }
    }
}
