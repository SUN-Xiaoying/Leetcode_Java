package str;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/description/

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                stack.push(component);
            }
        }

        // Construct the canonical path from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Return "/" if result is empty (this means the path was just the root "/")
        return result.length() > 0 ? result.toString() : "/";
    }


    // 13ms Beats 7.46%,           Miss one case result.length==0
    // 205 / 262 testcases passed, PROND OF YOU
    public String mine(String path) {
        String[] inputs = path.split("/+");
        Stack<String> myStack = new Stack<>();
        String result="";
        for(int i=1; i<inputs.length; i++){
            if(inputs[i].equals("..")){
                if(!myStack.isEmpty()){
                    myStack.pop();
                }
            }else if(inputs[i].equals(".")){
                continue;
            } else {
                myStack.push(inputs[i]);
            }
        }
        int n=myStack.size();
        for(int i=0; i<n; i++){
            result = "/" + myStack.pop() + result;
        }
        return result.length()==0 ? "/" : result;
    }

    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        String path1="/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path1));
    }
}
