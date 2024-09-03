package stack.parenthese;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParenthese {

    // https://www.youtube.com/watch?v=39CEPFCl5sE
    // 3ms Beats 71.08%

    public static int longestValidParentheses(String s) {
        if(s.length()<=1){ return 0;}
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.add(-1);
        char[] chars = s.toCharArray();
        int len=0, max_len=Integer.MIN_VALUE;

        for(int i=0; i<s.length(); i++){
            if(chars[i]=='('){
                myStack.add(i);
            }else{
                myStack.pop();
                if(myStack.isEmpty()){
                    myStack.add(i);
                } else {
                    len =i-myStack.peek();
                    max_len = Math.max(max_len, len);
                }
            }
        }

        return max_len==Integer.MIN_VALUE ? 0 : max_len;
    }
    // 123 / 231 testcases passed
    public static int mine(String s) {
        Stack<Character> myStack = new Stack<Character>();
        int len=0, result=Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            if(myStack.size()==0 ||  ch=='(' || ch == '[' || ch=='{'){
                myStack.add(ch);
            } else {
                char top = myStack.pop();

                if( (ch==')' && top=='(') ||
                    (ch=='}' && top=='{') || 
                    (ch==']' && top=='[')){
                    len+=2;
                } else {
                    result = Math.max(len, result);
                    myStack.clear();
                    len=0;
                }
            }
            result = Math.max(len, result);
        }

        return result;
    }

    public static void main(String[] args) {
        String s ="()(()";

        System.out.println(longestValidParentheses(s));
    }
}
