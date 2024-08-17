package stack;

import java.util.Stack;

public class BalanceBraket {

    // ChatGPT
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if((ch==')' && top!='(') ||
                    (ch=='}' && top!='{') ||
                    (ch==']' && top!='[')){
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }








    // RunTime Error
    public static String mine(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        if(chars[0] == '}' || chars[0]==']' || chars[0]==')'){
            return "NO";
        }
        stack.add(chars[0]);
        for(int i=1; i<chars.length; i++){
            if(chars[i] == '}'){
                if(stack.peek()!='{'){
                    return "NO";
                }
                stack.pop();
            } else if(chars[i]==']'){
                if(stack.peek()!='['){
                    return "NO";
                }
                stack.pop();
            } else if(chars[i] == ')'){
                if(stack.peek()!='('){
                    return "NO";
                }
                stack.pop();
            } else {
                stack.add(chars[i]);
            }
        }
        if(stack.size() != 0){
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        String s ="{[()]}";

        System.out.println(isBalanced(s));

    }

}
