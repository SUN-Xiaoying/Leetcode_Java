package dp;

public class Adjacent {
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        // F(n) = max(F(n-1), F(n-2)+curr)
        int sum1 = 0, sum2 = 0;
        for(int i=0; i< nums.length; i++){
            if( (i%2) == 1){
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }

        return Math.max(sum1, sum2);
    }
}
