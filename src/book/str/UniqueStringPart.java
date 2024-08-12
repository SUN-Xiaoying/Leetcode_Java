package book.str;

import java.util.HashSet;
import java.util.Set;

public class UniqueStringPart {

    // mine
    public int partitionString(String s) {
        int result = 0;

        String subString ="";
        for(char c: s.toCharArray()){
            if(subString.indexOf(c) >= 0){
                subString = String.valueOf(c);
                result++;
            } else {
                subString += c;
            }
        }
        return result+1;
    }

    // ChatGPT 4
    public int partitionString2(String s) {
        int result = 1; 
        Set<Character> seen = new HashSet<>(); 

        for (char c : s.toCharArray()) { // Iterate through each character in the string
            if (seen.contains(c)) { // If the character is already in the set
                result++; // Increment the result (start a new substring)
                seen.clear(); // Clear the set to start tracking a new substring
            }
            seen.add(c); // Add the character to the set
        }

        return result; // Return the number of substrings
    }
    
}
