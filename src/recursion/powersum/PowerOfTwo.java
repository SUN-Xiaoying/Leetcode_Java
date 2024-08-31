package recursion.powersum;

// https://leetcode.com/problems/power-of-two/

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        // n must be greater than 0, and n & (n - 1) must be 0
        return n > 0 && (n & (n - 1)) == 0;
    }


    public boolean isPowerOfTwoRecursion(int n) {
        if (n <= 0) {
            return false;  // Powers of two must be positive.
        }
        
        if (n == 1) {
            return true;  // Base case: 1 is 2^0, so return true.
        }
        
        if (n % 2 != 0) {
            return false;  // If n is not divisible by 2, it can't be a power of two.
        }
        
        return isPowerOfTwo(n / 2);  // Recursively check n / 2.
    }

    // 594 / 1110 testcases passed
    // More than 50%, COOL
    public boolean mine(int n) {
        if(n%2!=0 && n!=1){
            return false;
        }
        return true;
    }
}
