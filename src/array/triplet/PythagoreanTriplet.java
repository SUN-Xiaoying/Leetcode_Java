package array.triplet;

import java.util.Arrays;
import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/pythagorean-triplet3018/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class PythagoreanTriplet {

    // Hash set
    // 1009 /1115 Time Limit Exceeded
    public static boolean checkTriplet(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // Step 2: Use a HashSet to store squares
        HashSet<Integer> squares = new HashSet<>();
        for (int num : arr) {
            squares.add(num);
        }

        // Step 3: Check for any triplet (a^2 + b^2 = c^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if there exists a c^2 such that a^2 + b^2 = c^2
                int sumOfSquares = arr[i] + arr[j];
                if (squares.contains(sumOfSquares)) {
                    return true;
                }
            }
        }

        // If no triplet is found
        return false;
    }

    // Two pointers
    // 644 /1115 Time Limit Exceeded
    public static boolean checkTriplet2(int arr[], int n) {
	    // code here
        int[] square = new int[n];

        for(int i=0; i<n; i++){
            square[i] = arr[i]*arr[i];
        }

        Arrays.sort(square);

        for(int i=n-1; i>0; i--){
            int l=0;
            int r=square[i-1];

            while(l<r){
                if(square[l] + square[r] == square[i]){
                    return true;
                } else if (square[l] + square[r] < square[i]) {
                    l++;
                } else {
                    r--;
                }
            }
            
        }

        return false; 
	}

    public static void main(String[] args) {
        
    }
}
