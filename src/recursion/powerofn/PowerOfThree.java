package recursion.powerofn;

// https://leetcode.com/problems/power-of-three/description/

public class PowerOfThree {

    // 8ms Beats 88.50%
    public boolean isPowerOfThreeRecursion(int n) {
        if(n==0){
            return false;
        }

        if(n==1){
            return true;
        }

        if(n%3!=0){
            return false;
        }

        return isPowerOfThreeRecursion(n/3);
    }

}
