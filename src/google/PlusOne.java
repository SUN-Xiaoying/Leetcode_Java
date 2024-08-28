package google;

import java.util.Stack;

// https://leetcode.com/problems/plus-one/
public class PlusOne {

    // ChatGPT, 0ms, Beats 100%
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        
        return newNumber;
    }

    // 1ms, Beats 5,83%
    public static int[] mine(int[] digits) {

        Stack<Integer> stack = new Stack<Integer>();
        int n = digits.length;
        int carry= 1, sum =0;
        for(int i=n-1; i>=0; i--){
            sum = digits[i] + carry;
            stack.push(sum % 10);
            carry= sum / 10;
        }

        if(carry>0){
            stack.push(carry);
        }
        int stackSize = stack.size();
        int[] result = new int[stackSize];

        for(int i=0; i<stackSize; i++){
            result[i] = stack.get(stackSize-i-1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] result = plusOne(digits);

        for(int num : result){
            System.out.println(num);
        }
    }
}
