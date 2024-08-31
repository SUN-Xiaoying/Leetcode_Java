package recursion.powersum;

// https://www.hackerrank.com/challenges/the-power-sum/problem?isFullScreen=true
public class PowerSum {
    public static int mine(int X, int N) {
        // Write your code here
            double root = Math.pow(X, 1.0 / N);
            if(Math.round(root) != root){
                return 0;
            }

            int rootInt = 0;
            if(rootInt==0 || rootInt==1){
                return 1;
            }
            int result = 0;
            for(int i=0; i<=(rootInt+1)/2; i++){
                result += powerSum(i, N) + powerSum(X-i, N);
            }
            
            return result;
        }

    // ChatGPT
    public static int powerSum(int X, int N) {
        return powerSumHelper(X, N, 1);
    }

    private static int powerSumHelper(int X, int N, int num){
        int power = (int)Math.pow(num, N);

        if(power>X){
            return 0;
        } else if(power == X){
            return 1;
        } else {
            return powerSumHelper(X-power, N, num+1) + powerSumHelper(X, N, num+1);
        }
    }

    public static void main(String[] args) {
        int X=100;
        int N=2;

        System.out.println(powerSum(X, N));
    }
}
