package str.repeat;
/*
 * https://leetcode.com/problems/repeated-string-match/description/
*/
public class RepeatStringMatch {


    // https://www.youtube.com/watch?v=l1j01Z1AOAU
    // 265ms Beats 36.04%
    // public static int repeatedStringMatch(String a, String b) {
        // int m = a.length();
        // int n = b.length();
        
        // int repeatCount = (n + m - 1) / m; // Equivalent to Math.ceil((double) n / m)
        
        // // Java version less than 11
        // StringBuilder repeatedA = new StringBuilder(a.repeat(repeatCount));
        
        // if (repeatedA.toString().contains(b)) {
        //     return repeatCount;
        // }
        
        // repeatedA.append(a);
        // if (repeatedA.toString().contains(b)) {
        //     return repeatCount + 1;
        // }

        // return -1;
    // }

    // 635ms Beats 5.01%
    public static int mine(String a, String b) {
        String unit=a;
        int times=1;
        while(a.length()<b.length() || !a.contains(b)){
            a+=unit;
            times++;
            // 投机取巧
            if(times >3 && !a.contains(b) && !b.contains(a)){return -1;}
        }
        return times;
    }

    public static void main(String[] args) {
        String a ="abc";
        String b ="cabcabca";
        System.out.println(mine(a, b));
    }
}
