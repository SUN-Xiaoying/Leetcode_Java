package dp;

// https://leetcode.com/problems/house-robber/description/

public class HouseRobber {
    // 0ms Beats 100.00%

    public int rob(int[] nums) {
        int rob1=0, rob2=0, temp=0;

        for(int num:nums){
            temp=Math.max(rob1+num, rob2);
            rob1=rob2;
            rob2=temp;
        }

        return temp;
    }
}
