package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(0, cur, 0, result, candidates, target);

        return result;
    }

    public void dfs(int i, List<Integer> cur, int total, List<List<Integer>> result, int[] candidates, int target){
        // Termination
       
        if(total == target){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(i>=candidates.length || total>target){
            return;
        }

        // Recusion 
        cur.add(candidates[i]);
        dfs(i, cur, total+candidates[i], result, candidates, target);
        cur.remove(cur.size()-1);
        dfs(i+1, cur, total, result, candidates, target);
    }


    public static List<List<Integer>> combinationSumMine(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        for(int i=0; i<n && candidates[i]<=target; i++){
            f(0, candidates, target);
        }

        return result;
    }

    private static List<List<Integer>> f(int i, int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(candidates[i] > target){
            return result;
        }
        if(candidates[i] == target){
            List<Integer> list = new ArrayList<Integer>();
            list.add(candidates[i]);
            result.add(list);
            return result;
        }

        
        List<List<Integer>> comList =  f(i, candidates, target-candidates[i]);

        for(List<Integer> com: comList){
            List<Integer> list = new ArrayList<Integer>(com);
            list.add(candidates[i]);
            result.add(list);
        }

        return result;
    }
}
