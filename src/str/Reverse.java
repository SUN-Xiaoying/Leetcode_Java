package str;

public class Reverse {
    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
//        reverseString(s);
//        System.out.println(s);
        int num = -123;

        System.out.println(reverseInt(num));

    }

    public static void reverseString(char[] s) {
        // Seems to be no better way
        int i = 0;
        int j = s.length - 1;
        char ch;
        while (i < j) {
            ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            j--;
            i++;
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

