package recursion;

import java.util.Arrays;
import java.util.List;

public class MinBride {
//     mine failed for: 8
//     1 2 5 3 7 8 6 4
    public static void mine(List<Integer> q) {
    // Write your code here
        int result=0;
        for(int i=0; i<q.size(); i++){
            int diff = q.get(i)-i-1;
            if(diff > 2){
                System.out.println("Too chaotic");
                return;
            } else {
                result += diff>0? diff: 0;
            }
        }
        System.out.println(result);
        
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for(int i=0; i<q.size(); i++){
            if(q.get(i)-i-1 > 2){
                System.out.println("Too chaotic");
                return;
            }

            for(int j=Math.max(0, q.get(i)-2); j<i; j++){
                if(q.get(j) > q.get(i)){
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);

        mine(list);
        minimumBribes(list);
    }
}
