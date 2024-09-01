package dp.longestlength;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/length-of-the-longest-valid-substring/description/
public class LongestValidSubString {

    // https://www.youtube.com/watch?v=3lwljfBo9ww
    // public static int longestValidSubstring(String word, List<String> forbidden){
    //     int n = word.length();
        
    // }

    // Mine, V1, 367 / 763 testcases passed, NOT BAD
    public static int mine(String word, List<String> forbidden) {
        String sub="";
        int len=Integer.MIN_VALUE;
        int n = word.length();
        for(int l=0, r=0; l<n; r++){
            sub+=word.charAt(r%n);
            for(String fob: forbidden){
                if(sub.toLowerCase().contains(fob.toLowerCase())){
                    len=Math.max(Math.abs(r-l), len);
                    l=r;
                    sub=String.valueOf(word.charAt(r%n));
                    break;
                }
            }
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        List<String> forbidden = new ArrayList<String>();
        // forbidden.add("de");
        // forbidden.add("le");
        // forbidden.add("e");
        forbidden.add("aaa");
        forbidden.add("cb");
        
        // System.out.println(longestValidSubstring(word1, forbidden));
    }
}
