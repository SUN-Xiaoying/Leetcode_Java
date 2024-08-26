package twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/heaters/
public class Heaters {

    // ChatGPT
    public static int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int maxRadius = 0;
        
        for (int house : houses) {
            // Use binary search to find the closest heater to the current house
            int idx = Arrays.binarySearch(heaters, house);
            
            if (idx < 0) {
                // If the house is not exactly at a heater's position, get the insertion point
                idx = -(idx + 1);
            }
            
            // Distance to the closest left heater
            int dist1 = (idx > 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            
            // Distance to the closest right heater
            int dist2 = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
            
            // The closest heater is the minimum of these two distances
            int closestDistance = Math.min(dist1, dist2);
            
            // The required radius is the maximum of the minimum distances
            maxRadius = Math.max(maxRadius, closestDistance);
        }
            
        return maxRadius;
    }

    // 18 / 30 testcases passed
    public static int findRadius2(int[] houses, int[] heaters) { 
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;

        for(int i=0, j=0; i<houses.length; i++){
            if(!(j==heaters.length-1 || Math.abs(houses[i]-heaters[j]) < Math.abs(houses[i]-heaters[j+1]))){
                j++;
            }
            result = Math.max(result, Math.abs(houses[i]-heaters[j]));
        }

        return result;
        
    }


    // 11 / 30 testcases passed
    // Edge Case
    public int mine(int[] houses, int[] heaters) {

        int n = heaters.length;
        int start = Math.abs(houses[0]-heaters[0]);
        // 如果最后一个供暖器，离得特别远，根本用不上
        int end = Math.abs(houses[houses.length-1]-heaters[n-1]);
        int result = Math.max(start, end);

        int gap=0;
        for(int i=0; i<n-1; i++){
            gap = Math.max(gap, heaters[i+1]-heaters[i]);
        }

        return Math.max((int)Math.ceil(gap/2), result);
    }

    public static void main(String[] args) {
        // int[] houses = {1,5,7,10,12,15};
        // int[] heaters = {3,6,10,13,19};
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};

        System.out.println(findRadius(houses, heaters));
    }
}
