package book;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class TimeInWords {
    public static String[] NUM_IN_WORDS = {"o' clock", "one", "two", "three", "four", "five", "six", "seven","eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen","eighteen","nineteen","twenty","twenty one","twenty two","twenty three","twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"};

     public static String timeInWords(int h, int m) {
        // Write your code here
            String hour = NUM_IN_WORDS[h];
            
            if(m == 0){
                return hour+" "+NUM_IN_WORDS[m];
            } else if (m==1) {
                return NUM_IN_WORDS[m] + " minute past " + hour;
            } else if (m==15 || m==30) {
                return NUM_IN_WORDS[m] + " past " + hour;
            } else if (m<30){
                return NUM_IN_WORDS[m] + " minutes past " + hour;
            } else if(m==45) {
                return NUM_IN_WORDS[60 - m] + " to " + NUM_IN_WORDS[h+1];
            } else {
                return NUM_IN_WORDS[60 - m] + " minutes to " + NUM_IN_WORDS[h+1];
            } 
            
        }

    public static int wordsToNumber(String word) {
        // Normalize the input string (e.g., trim, lowercase)
        word = word.trim().toLowerCase();
        
        // // Special case for "o' clock"
        // if (word.equals("o' clock")) {
        //     return 0;
        // }
        
        // Find the index of the word in the array
        for (int i = 0; i < NUM_IN_WORDS.length; i++) {
            if (NUM_IN_WORDS[i].equals(word)) {
                return i;
            }
        }
        
        // If the word is not found, throw an exception
        throw new IllegalArgumentException("Invalid word: " + word);
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int h = Integer.parseInt(bufferedReader.readLine().trim());

        // int m = Integer.parseInt(bufferedReader.readLine().trim());

        // String result = Result.timeInWords(h, m);

        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
        int number = wordsToNumber("one");
        System.out.println(number);
    }
}

