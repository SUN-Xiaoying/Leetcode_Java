package str;

public class StrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {


        return -1;
    }

    public int strStrWindow(String haystack, String needle) {

        if (haystack.length() == 1) {
            return haystack.equals(needle) ? 0 : -1;
        }
        // 双指针
        int i = 0;
        int needleLen = needle.length();
        String sub;
        // Sliding Window
        while (i < haystack.length() - needleLen) {
            sub = haystack.substring(i, i + needleLen);
            if (sub.contentEquals(needle)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
