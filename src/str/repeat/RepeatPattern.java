package str.repeat;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 */
public class RepeatPattern {

    // Is ChatGPT Crazy?
    // 76ms Beats 24.63%
    public static boolean repeatedSubstringPattern(String s) {
        String s2 = s + s;
        return s2.substring(1, s2.length() - 1).contains(s);
    }

    // 67 / 129 testcases passed
    // What if the repeating pattern is "aba"?
    public static boolean secondTry(String s) {
        if(s.length()<=1){return false;}
        String pattern = "";
        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length;){
            if(pattern.length()==0 || pattern.indexOf(chars[i])==-1){
                pattern += chars[i++];
            } else {
                for(char ch:pattern.toCharArray()){
                    if(i>=chars.length || ch!=chars[i++]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean stack(String s) {

        // 52 / 129 testcases passed
        // "ababab", stack is not empty
        Queue<Character> pattern = new LinkedList<Character>();

        for(char ch:s.toCharArray()){
            if(pattern.isEmpty() || !pattern.contains(ch)){
                pattern.add(ch);
            }else{
                if(ch != pattern.poll()){
                    return false;
                }
            }
        }

        return pattern.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s ="abcabcabcabc";

        System.out.println(repeatedSubstringPattern(s));
    }
}