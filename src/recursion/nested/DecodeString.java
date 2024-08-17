package recursion.nested;


// https://leetcode.com/problems/decode-string/description/
public class DecodeString {

    public static int where;
    public static String decodeString(String s) {
        
        char[] chars = s.toCharArray();
        return f1(chars, 0);
    }

    public static String f1(char[] chars, int i){
        StringBuilder path = new StringBuilder();
        int cur = 0;

        while(i<chars.length && chars[i] != ']'){
            if(chars[i] >= '0' && chars[i] <= '9') {
                cur = cur*10 + chars[i++] - '0';
            } else if(chars[i]>= 'a' && chars[i] <= 'z'){
                path.append(chars[i++]);
            } else {
                path.append(repeat(cur, f1(chars, i+1)));
                i = where + 1;
                cur=0;
            } 
        }
        where = i;

        return path.toString();
    }

    public static String repeat( int times, String s) {
        StringBuilder result= new StringBuilder();
        for(int i=0; i<times; i++){
            result.append(s);
        }

        return result.toString();
    }



    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
