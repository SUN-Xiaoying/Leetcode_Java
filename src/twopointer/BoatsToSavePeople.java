package twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/description/
public class BoatsToSavePeople {

    // 17ms Beats 19.91%
    // O(nlog(n))
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l=0, r=n-1;
        int sum =0, result=0;
        

        while(l<=r){
            sum = l==r ? people[l] : people[l]+people[r];

            if(sum>limit){
                r--;
            }else{
                // 每艘船最多可以同时载两人
                r--;
                l++;
            }

            result++;
        }

        return result;
    }



    // 38 / 78 testcases passed
    // l+r
    public static int mine(int[] people, int limit) {
        Arrays.sort(people);
        int result=1;

        int i=0;
        int rest=limit;
        while(i<people.length-1){
            if(rest-people[i] < people[i+1]){
                result++;
                i++;
                rest=limit;
            } else {
                rest -= people[i++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit =3;

        System.out.println(numRescueBoats(people, limit));
    }
}
