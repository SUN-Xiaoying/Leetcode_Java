package ascii;

public class CeaeserChipher {
    public static String caesarCipher(String s, int k) {
        // Write your code here
            String result = "";
            for(char ch: s.toCharArray()){
                if (ch >= 'a' && ch <= 'z') {
                    result += (char)((ch-'a'+k)%26 + 'a');
                } else if (ch >= 'A' && ch <= 'Z'){
                    result += (char)((ch-'A'+k)%26 + 'A');
                } else {
                    result += ch;
                }
            }
            return result;
        }
}
