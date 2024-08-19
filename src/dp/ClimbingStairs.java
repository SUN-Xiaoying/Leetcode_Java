package dp;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    // Bring the CACHE
    // ChatGPT 0ms Beats 100.00%

    public static int climbStairs(int n) {
        if(n<0) {
            return 0;
        } 
        if(n==0 || n==1 || n==2 || n==3){
            return n;
        }

        int[] dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    
    // 31 / 45 testcases passed, pround of you!
    public int mine(int n) {
        if(n<0) {
            return 0;
        } 
        if(n==0 || n==1 || n==2 || n==3){
            return n;
        }
        // termination
        return mine(n-1) + mine(n-2);
        
    }

    public int climbStairs_old(int n) {
        if(n<3){
            return n;
        }
        int a = 1;
        int b = 2;
        int temp = 0;

        // F(n) = F(n-1) + F(n-2)
        for(int i =3; i<=n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }

    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();

        // One-pass hash
        for(int i=0; i<numbers.length; i++){
            int complement = target - numbers[i];
            if(myMap.containsKey(complement)){
                return new int[]{myMap.get(complement), i};
            }
            myMap.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int n=5;
        System.out.println(climbStairs(n));
    }
}
