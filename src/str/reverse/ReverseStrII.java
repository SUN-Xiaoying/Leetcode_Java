package str.reverse;

/*
 * https://leetcode.com/problems/reverse-string-ii/
*/
public class ReverseStrII {
    /*
     * ChatGPT: 对下标掌控力更好
    */
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray(); 
        int n = arr.length;
        // 
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); 

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(arr); // Convert back to string
    }

    /*
     * 5ms Beats 10.73%
     */
    public static String mine(String s, int k) {
        int l = 0,r = 0;
        char[] chars = s.toCharArray();
        char ch;

        for(int i=0; i<s.length(); i+=2){
            l=k*i;
            r= k*(i+1)-1>s.length()-1 ? s.length()-1 : k*(i+1)-1;
            while(l<r){
                ch=chars[l];
                chars[l]=chars[r];
                chars[r]=ch;
                l++;
                r--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
