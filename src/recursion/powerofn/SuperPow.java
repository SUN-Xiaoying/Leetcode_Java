package recursion.powerofn;

// https://leetcode.com/problems/super-pow/description/
public class SuperPow {

    // mybacktrack
    // 3 / 57 testcases passed
    // (x×y)modm=((xmodm)×(ymodm))modm
    public int superPow(int a, int[] b) {
        if(a==1){
            return 1;
        }

        long n =0;
        for(int num: b){
            n = n*10 + num;
        }

        return (int) powHelper(a, n);
    }

    private long powHelper(int x, long n){
        if(n==0){ return 1;}
        if(n==1){ return x;}

        long res = powHelper(x*x, Math.floorDiv(n,2))%1337;

        return n%2==0 ? res%1337 : (x*res)%1337;
    }

    // 4 / 57 testcases passed
    public int mine(int a, int[] b) {
        long exponent=0;

        for(int num : b){
            exponent=exponent*10 + num;
        }

        return (int) Math.pow(a, exponent)%1337;
    }
}
