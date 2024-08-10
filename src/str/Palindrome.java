package str;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        // String str = "A man, a plan, a canal: Panama";
        String str1 = ",,,,,,,,,,,,acva";
        System.out.println(isPalindrome(str1));
    }
    public static boolean isPalindrome(String s) {
        s =s.toLowerCase();
        Stack<Character> myStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                myStack.push(s.charAt(i));
            }
        }

        int i=0;
        while(!myStack.isEmpty()){
            if(Character.isLetterOrDigit(s.charAt(i))){
                if(myStack.pop() != s.charAt(i)){
                    return false;
                }
            }
            i++;
        }

        return true;
    }

//    public static String longestPalindrome(String s) {
//
//    }
}
