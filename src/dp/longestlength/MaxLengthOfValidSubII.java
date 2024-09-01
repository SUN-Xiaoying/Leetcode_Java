package dp.longestlength;

public class MaxLengthOfValidSubII {
    // chatGPT, backtrack
    // 45ms Beats 45.58%
    public static int maximumLength(int[] nums, int k) {
        int n=nums.length;
        if(n<=1){return n;}

        int[][] dp = new int[n][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                dp[i][j] =1;
            }
        }
        int length=1, sum=0;


        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                sum = (nums[i] + nums[j])%k;

                dp[i][sum] = Math.max(dp[i][sum], dp[j][sum]+1);

                length=Math.max(length, dp[i][sum]);
            }
        }

        return length;
    }

    // Wrong answer
    // prev don't have to be adjacent
    public static int mine(int[] nums, int k) {
        if(k<nums[0]){
            return 0;
        }

        int[][] dp = new int[nums.length][k];
        int length = Integer.MIN_VALUE, sum=0, prev=0;

        for(int i=0; i<nums.length-1; i++){
            prev=nums[i];
            
            for(int j=i+1; j<nums.length; j++){
                sum = (nums[j]+prev)%k;
                dp[i][sum]++;
                prev=nums[j];
            }
            length= Math.max(length, dp[i][sum]);
        } 

        return length;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,2,3,1,4};
        int k = 3;

        System.out.println(maximumLength(nums, k));

    }
}
