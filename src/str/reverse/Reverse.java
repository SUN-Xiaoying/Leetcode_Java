package str.reverse;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
//        reverseString(s);
//        System.out.println(s);
        int num = -123;

        System.out.println(reverseInt(num));

    }

    /*
     * ChatGPT: 1ms Beats 24.50%
    */
    public static void reverseString(char[] s) {
        // Seems to be no better way
        int l = 0;
        int r = s.length - 1;
        char ch;
        while (l < r) {
            ch = s[l];
            s[l] = s[r];
            s[r] = ch;
            r--;
            l++;
        }
    }

    /*
     * 2024-09-09
     * mine: 4ms
    */
    public void reverseString2(char[] s) {
        Stack<Character> stack = new Stack<Character>();

        for(char ch: s){
            stack.add(ch);
        }

        for(int i=0; i<s.length; i++){
            s[i] = stack.pop();
        }
    }

    public static int reverseInt(int x) {
        // Integer to String
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();

        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        // java 1.8
        char[] chs = Integer.toString(Math.abs(x)).toCharArray();

        int j = chs.length - 1;
        String str = "";

        while (j >= 0) {
            str += chs[j];
            j--;
        }

        try {
            return x < 0 ? Integer.parseInt(str) * -1 : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

