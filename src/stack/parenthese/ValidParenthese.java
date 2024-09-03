package stack.parenthese;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthese {
    // 1ms Beats 98.71%
    // I REMEMBER
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<Character>();

        for(char ch : s.toCharArray()){
            if(myStack.size()==0 ||  ch=='(' || ch == '[' || ch=='{'){
                myStack.add(ch);
            } else {
                char top = myStack.pop();
                if( (ch==')' && top!='(') ||
                    (ch=='}' && top!='{') || 
                    (ch==']' && top!='[')
                ){
                    return false;
                }

            }
        }
        
        return myStack.size()!=0 ? false : true;
    }
}
