package greedy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/largest-number/description/
 * https://www.youtube.com/watch?v=7lrD9J73QtE&list=PLvKfL6GtwDxwuyrpAJfU3HTnPZl4WnraE&index=89&ab_channel=%E5%B7%A6%E7%A8%8B%E4%BA%91
*/
public class LargestNumber {

    // 6ms Beats 54.31%
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        /*
        * One line rules the world
        */ 
        Arrays.sort(strs, (a,b) -> (b+a).compareTo(a+b));

        /*
        * Don't forget nums = [0,0]
        */ 
        if(strs[0]=="0"){ return "0"; }

        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            sb.append(s);
        }

        return sb.toString();
    }

    public static String mine(int[] nums) {
        int n = nums.length;
        for(int i=0, keep=0, swap=0, temp=0; i<n-1; i++){
            keep = appendNumbers(nums[i], nums[i+1]);
            swap = appendNumbers(nums[i+1], nums[i]);

            if(swap > keep){
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: nums){
            sb.append(num);
        }

        return sb.toString();
    }

    public static int appendNumbers(int num1, int num2){
        StringBuilder sb = new StringBuilder();
        sb.append(num1);
        sb.append(num2);

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
