package book;

import java.util.List;

public class FlipMatrix {
    
    public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
        int result = 0;
        int n = matrix.size()/2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int maxVal = Math.max(
                    Math.max(matrix.get(i).get(j), matrix.get(i).get(2*n-j-1)),
                    Math.max(matrix.get(2*n-i-1).get(j), matrix.get(2*n-i-1).get(2*n-j-1))
                );
                result += maxVal;
            }
        }
        return result;
    }

    public static void main(String[] args){

    }
}
