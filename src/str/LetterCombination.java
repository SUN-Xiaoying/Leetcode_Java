package str;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    // ChatGPT, 0ms
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public static List<String>  letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    private static void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1); // backtrack
        }
    }

    // mine 5ms
    public static String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations2(String digits) {
        char[] nums = digits.toCharArray();
        List<String> result = new ArrayList<>();

        for(int i=nums.length-1; i>=0; i--){
            String cur = chars[ nums[i]-'0' ];
            result = combine(cur, result);
        }

        return result;
    }

    public static List<String> combine(String s, List<String> list){
        List<String> result = new ArrayList<>();
        if(list.isEmpty()){
            for(char ch: s.toCharArray()){
                result.add(String.valueOf(ch));
            }
        } else {
            for(char ch: s.toCharArray()){
                for(String str: list){
                    result.add(ch+str);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";

        List<String> result = letterCombinations(digits);

        for(String s: result){
            System.out.println(s);
        }
    }
}
