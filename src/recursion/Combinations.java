package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combinations/description/
public class Combinations {

    // If you don't use global varaible
    // 17ms Beats 85.94%

    public int nn;
    public int kk;


    // BACKTRACK
    // 22ms Beats 30.33%
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        nn = n;
        kk = k;
        backtrack(1, comb, result);
        return result;

    }


    private void backtrack(int start, List<Integer> comb, List<List<Integer>> result){
        if(comb.size() == kk){
            result.add(comb);
            return;
        }

        for(int i=start; i<nn+1; i++){
            comb.add(i);
            backtrack(i+1, comb, result);
            comb.remove(comb.size()-1);
        }
    }


    // Recursive
    // 101ms Beats 5.07%
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(k==1){
            while(n>0){
                List<Integer> list = Arrays.asList(n--);
                result.add(list);
            }

            return result;
        }

        while(n>0 && k>1){
            int tail = n;
            List<List<Integer>> perms = combine(n-1, k-1);
    
            for(List<Integer> perm: perms){
                List<Integer> newPerm = new ArrayList<Integer>(perm);
                newPerm.add(tail);
                result.add(newPerm);
            }
            n--;
        }

        return result;
    }


    public static void main(String[] args) {
        int n = 4, k = 2;

        List<List<Integer>> result = combine(n, k);

        for(List<Integer> list : result){
            list.stream().forEach(i -> System.out.print(i));
            System.out.println("");
        }
    }

}
