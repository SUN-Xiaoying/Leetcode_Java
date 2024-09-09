package str.regularexpression;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/regular-expression-matching/description/
 */

public class RegularExpressionMatch {

    // ChatGPT
    // 8ms Beats 26.23%
    Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }

    private boolean isMatchHelper(String s, String p, int i, int j) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (j == p.length()) {
            return i == s.length();
        }

        boolean firstMatch = (i < s.length() && 
                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean exclude = isMatchHelper(s, p, i, j + 2); // Skip the '*' and preceding char
            boolean include = firstMatch && isMatchHelper(s, p, i + 1, j); // Use '*'
            memo.put(key, exclude || include);
            return memo.get(key);
        } else {
            boolean result = firstMatch && isMatchHelper(s, p, i + 1, j + 1);
            memo.put(key, result);
            return result;
        }
    }
    /*  
        Top-down memorization
        https://www.youtube.com/watch?v=HAA8mgxlov8&ab_channel=NeetCode
    */
    public boolean mine1(String s, String p) {
        int M=s.length();
        int N=p.length();

        boolean[][] dp = new boolean[M][N];
        
        return dfs1(0,0,dp,s,p);
    }

    private boolean dfs1(int i, int j, boolean[][]dp, String s, String p){
        int M=s.length();
        int N=p.length();
        if(i>=M && j>=N){ return true;}
        if(j>=N){ return false;}
        // Index out of bound? i>=M && j<N 
        // 你怎么实现复用啊？
        if(i<M && dp[i][j]){return dp[i][j];}
        boolean match = (i<M && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if(j+1<N && p.charAt(j+1)=='*'){
            dp[i][j] = (dfs1(i, j+2, dp, s, p)) || (match && dfs1(i+1, j, dp, s, p));
        }else if(match){
            dp[i][j] = dfs1(i+1, j+1, dp, s, p);
        } else {
            dp[i][j]=false;
        }
        return dp[i][j];
    }


    // 257 / 354 testcases passed
    // 也没那么难嘛
    public boolean mine(String s, String p) {
        int l=0, r=0;
        int m=s.length();
        int n=p.length();

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        while(l<m && r<n){
            if(ss[l] == pp[r] || pp[r]=='.'){
                l++;
                r++;
            // preceding element 
            } else if(pp[r]=='*'){
                while(ss[l]==pp[r]){
                    l++;
                }
                r++;
            } else {
                return false;
            }
        }
        return l==m-1 && r==n-1 ? true : false;
    }

    public static void main(String[] args) {
        // String s = "ab";
        // String p = ".*";

        // System.out.println(isMatch(s, p));
    }
}
