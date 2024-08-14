package str;

public class PalindromeNumber {

    // ChatGPT
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // If the number is a palindrome, reversedHalf should be equal to x
        // or reversedHalf without the last digit (for odd number of digits) should equal x
        return x == reversedHalf || x == reversedHalf / 10;
    }

    // mine failed for 1410110141
    public boolean mine(int x) {
        if(x<0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int div = 1;
        while(x >= div*10){
            div*= 10;
        }

        while(x>0){

            int right = x%10;
            int left = x/div;

            if(right != left){
                return false;
            } 

            x = (x%div)/10;
            div = div/100; 
        }

        return true;
    }
}
