package dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClimbingStairs {

    // https://www.cnblogs.com/Kevinmanlee/p/11110771.html
    public int climbStairs(int n) {
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


}
