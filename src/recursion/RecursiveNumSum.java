package recursion;

public class RecursiveNumSum {

    public static int superDigit(String n, int k) {
        // Write your code here
            
        String sum = String.valueOf(Integer.parseInt(getSum(n))*k);
        return Integer.parseInt(getSum(sum));
    }

    public static String getSum(String n){
        long sum =0;

        if(n.length() == 1){
            return n;
        } else {
            for(char ch: n.toCharArray()){
                sum += ch - '0';
            }
        }
        return getSum(String.valueOf(sum));
    }



    public static void main(String[] args) {
        String s = "9875";
        int k=4;
        System.out.println(superDigit(s, k));
    }
        
    
}
