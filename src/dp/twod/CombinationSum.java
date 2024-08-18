package dp.twod;

import java.util.ArrayList;
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
}
