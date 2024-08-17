package recursion.nested;

import java.util.ArrayList;
import java.util.List;

public class BasicCalculatorIII {

    public static int where =0;

    public static int calculate (String s) {
        // write code here
        char[] chars= s.toCharArray();
        
        return f1(chars, 0);

    }

    public static int f1(char[] chars, int i){
        int cur =0;
        List<Integer> nums = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();

        while(i<chars.length && chars[i] != ')'){
            if(chars[i] >= '0' && chars[i] <= '9'){
                cur = cur*10 + chars[i++] -'0';
            } else if (chars[i] != '(') {
                push(nums, ops, cur, chars[i++]);
                cur=0;
            } else {
                cur = f1(chars, i+1);
                i = where+1;
            }
        }
        // Last one
        push(nums, ops, cur, '+');
        where = i;
        return compute(nums, ops);
    }

    public static void push(List<Integer> nums, List<Character> ops, int cur, char op ){
        int n = nums.size();
        if(n==0 || ops.get(n-1) =='+' || ops.get(n-1)=='-'){
            nums.add(cur);
            ops.add(op);
        } else {
            int temp = nums.get(n-1);
            char symbol = ops.get(n-1);
            if(symbol=='*'){
                nums.set(n-1, temp*cur);
            } else {
                nums.set(n-1, temp/cur);
            }
            ops.set(n-1, op);
        }
    }

    public static int compute(List<Integer> nums, List<Character> ops){
        int ans = nums.get(0);
        for(int i=1; i<nums.size(); i++){
            ans += ops.get(i-1) == '+' ? nums.get(i) : -nums.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "(2*(3-4))*5";

        System.out.println(calculate(s));
        
    }
}
