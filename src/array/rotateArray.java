package array;

public class rotateArray {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
        int[] nums = {-1};
        int k = 2;
        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void rotate(int[] nums, int k) {

        // Arrays Out of Bound
        int pos = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, pos - 1);
        reverse(nums, pos, nums.length - 1);
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }
    }
}
