package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {

        int n = c.length;
        if(k>=n){
            return Arrays.stream(c).sum();
        } 
        
        int[] prevPurchase = new int[k];
        int result = 0;
        Arrays.sort(c);
        result = c[n-1]+c[n-2]+c[n-3];
        for(int i=0; i<k; i++){
            prevPurchase[i] += 1;
        }
        
        for(int j=0; j<n-3; j++){
            prevPurchase[j%k] += 1;
            result += prevPurchase[j%k]*c[j];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] c = {2,5,6};
        int k=2;

        System.out.println(getMinimumCost(k, c));
    }
}
