package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// return the longest public substring

public class SubString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        // basecase
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            System.out.println(0);
            return;
        }

        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        int row = 0;
        int col = cs2.length - 1;
        int max = 0; // O(1)

        while (row < cs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < cs1.length && j < cs2.length) {
                if (cs1[i] != cs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                max = Math.max(len, max);
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println(max);
    }
}
