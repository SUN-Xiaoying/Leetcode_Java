package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class AllDuplicate {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            cnt[nums[i]]++;
        }

        for(int j=0; j<n+1; j++){
            if(cnt[j]>1){
                list.add(j);
            }
        }

        return list;
    }
    
    public static void main(String[] args) {

    }
}
