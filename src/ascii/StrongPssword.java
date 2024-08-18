package ascii;

public class StrongPssword {
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
            
        int result = 0;
        int[] ledger = new int[4];
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                ledger[0] += 1;
            } else if (Character.isUpperCase(c)){
                ledger[1] += 1;
            } else if(Character.isDigit(c)){
                ledger[2] += 1;
            } else {
                ledger[3] += 1;
            }
        }
        
        for(int count: ledger){
            if(count==0){
                result++;
            }
        }
        
        int len = Math.max(6-n, 0);
        return len > result ? len : result;

    }
}