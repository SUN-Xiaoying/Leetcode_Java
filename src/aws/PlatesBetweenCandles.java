package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/plates-between-candles/description/

public class PlatesBetweenCandles {

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] rightCandle = new int[n];
        int[] leftCandle = new int[n];
        int[] platesSum = new int[n];
        int[] result = new int[queries.length];

        int lastCandle = -1;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='|'){
                lastCandle = i;
            }
            leftCandle[i]=lastCandle;
        }

        lastCandle = -1;
        // Watch out j > = 0
        for(int j=n-1; j>=0; j--){
            if(s.charAt(j)=='|'){
                lastCandle = j;
            }
            rightCandle[j]=lastCandle;
        }
        
        for(int k=0, sum=0; k<n; k++){
            if(s.charAt(k)=='*'){
                sum++;
            }
            platesSum[k]=sum;
        }

        for(int q=0; q<queries.length; q++){
            int left=rightCandle[queries[q][0]];
            int right=leftCandle[queries[q][1]];

            if (left != -1 && right != -1 && left < right) {
                result[q] = platesSum[right] - platesSum[left];
            } else {
                result[q] = 0;
            }
        }
        
        return result;
    }

    // Mine does not work
    public static int countPlates(int start, int end, List<Integer> cnts){
        int i=0, result=0;
        int n =cnts.size();
        while(cnts.get(i)<start && i<n-1){
            i++;
        }
        if(cnts.get(i)>=start){
            int head=i;
            while(cnts.get(i++)<end && i<n-1){
                result--;
            }
            i = i<n-1 ? i : n-1;
            return result+cnts.get(i)-cnts.get(head);
        }

        return 0;
    }

    public static int[] mine(String s, int[][] queries) {
        int n=queries.length;
        int[] result = new int[n];
        List<Integer> cnts = new ArrayList<Integer>();

        int pos = 0;

        while(pos<s.length()){
            if(s.charAt(pos)=='|'){
                cnts.add(pos);
            }
            pos++;
        }

        System.out.println(cnts.toString());
        // int l=0, r=0;
        // while(r<s.length()){ //  "***|**|*****|**||**|*"
            
        //     if(s.charAt(r) == '|'){  //r=16
        //         l=r;                 //l=16
        //         while(s.charAt(r++) == '*' && r<s.length()){ //r=17
        //             continue;
        //         }
        //         cnts.add(Arrays.asList(l,r)); //[3,6], [6,12], [12,13], [13,16], [16,19]
        //     } else{
        //         r++;
        //     }
        // }

        for(int i=0; i<n; i++){
            result[i] = countPlates(queries[i][0], queries[i][1], cnts);
        }

        return result;
        
    }
    
    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        int[] results = platesBetweenCandles(s, queries);

        for(int result: results){
            System.out.println(result);
        }
    }    
}
