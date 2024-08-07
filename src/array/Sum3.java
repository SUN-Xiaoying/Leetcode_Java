package array;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 11, 15};
        int[] arr = Arrays.stream(nums).toArray();
        Arrays.sort(nums);

        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

    // public List<List<Integer>> threeSum(int[] nums) {
    //     // 三数之和先排序
    //     Arrays.sort(nums);

    //     List<List<Integer>> results = new ArrayList<>();
    //     Set<List<Integer>> set = new HashSet<>();

    //     for (int i = 0; i < nums.length - 2; i++) {
    //         int j = i + 1;
    //         int k = nums.length - 1;

    //         while (j < k) {
    //             int sum = nums[i] + nums[j] + nums[k];

    //             if (sum < 0) {
    //                 j++;
    //             } else if (sum == 0) {
    //                 set.add(List.of(nums[i], nums[j], nums[k]));
    //                 j++;
    //                 k--;
    //             } else {
    //                 k--;
    //             }
    //         }
    //     }

    //     // 查重用Hash
    //     results.addAll(set);

    //     return results;
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return nums;
    }

    public int[] twoSumFail(int[] nums, int target) {
        int[] arr = nums;
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int diff = nums[i] + nums[j] - target;
            if (diff > 0) {
                j--;
            } else if (diff == 0) {
                // But they want position
                return new int[]{findIndex(arr, i), findIndex(arr, j)};
            } else {
                i++;
            }
        }

        return nums;
    }

    public static int findIndex(int[] arr, int target) {
        // if array is Null
        if (arr == null) {
            return -1;
        }

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // Give the-best-guess, failed for [3,3]
            if (arr[i] == target) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }
}
