package gcd;



// https://leetcode.com/problems/nth-magical-number/description/
public class MagicalNumber {
    private static long gcd(long a, long b){
        return b==0 ? a : gcd(b, a%b);
    }

    private static long lcm(long a, long b){
        return a/gcd(a,b) * b;
    }

    public static int nthMagicalNumber(int n, int a, int b) {
        long lcm = lcm(Math.max(a,b), Math.min(a,b));
        long l = 0, r = (long) n * Math.min(a, b);
        long mod = 1000000007;
        while(l<r){
            long m=l+(r-l)/2;
            if(m/a + m/b - m/lcm >= n){
                r=m;
            } else {
                l=m+1;
            }
        }

        return (int)(l%mod);
    }

    public static void main(String[] args) {
        int a=2, b=3, n=4;

        System.out.println(nthMagicalNumber(n, a, b));
    }
}
