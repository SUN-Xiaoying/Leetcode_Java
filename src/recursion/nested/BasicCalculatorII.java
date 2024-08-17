package recursion.nested;

import java.util.ArrayList;
import java.util.List;


public class BasicCalculatorII {
    public static int calculate (String s) {
        // write code here
        int cur=0;
        char[] chars = s.toCharArray();
        List<Integer> nums = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();

        for(int i=0; i<chars.length; i++){
            if(chars[i]>='0' && chars[i]<='9'){
                cur = cur*10 + chars[i] - '0';
            } else {
                push(nums, ops, cur, chars[i]);
                cur=0;
            }
        }
        push(nums, ops, cur, '+');

        return compute(nums, ops);

    }

    public static void push(List<Integer> nums, List<Character> ops, int cur, Character op){
        int n = nums.size();
        if(n==0 || ops.get(n-1) == '+' || ops.get(n-1) == '-'){
            nums.add(cur);
            ops.add(op);
        } else {
            int temp = nums.get(n-1);
            char symbol = ops.get(n-1);
            if(symbol == '*'){
                nums.set(n-1, temp * cur);
            } else {
                nums.set(n-1, temp / cur);
            }
            ops.set(n-1, op);
        }
    }

    public static int compute(List<Integer> nums, List<Character> ops){
        int result = nums.get(0);
        for(int i=1; i<nums.size(); i++){
            if (ops.get(i - 1) == '+') {
                result += nums.get(i);
            } else {
                result -= nums.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s= "8*9-19";
        System.out.println(calculate(s));
    }
}
