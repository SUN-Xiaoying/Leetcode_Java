package arrayAndString;

import java.util.*;
import java.util.stream.Collectors;

public class Sum3 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 三数之和先排序
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<nums.length-2; i++){
            int j = i+1;
            int k =nums.length-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum<0){
                    j++;
                } else if (sum==0) {
                    set.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else {
                    k--;
                }
            }
        }

        // 查重用Hash
        results.addAll(set);

        return results;
    }
}
