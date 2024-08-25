package twopointer;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrapRainWater {

    // 双指针法
    // 0ms Beats 100.00%, O(n)
    public static int trap2(int[] height) {
        int n = height.length;
        if(n <= 2){
            return 0;
        } 

        int l=1, r=n-2, lmax=height[0], rmax=height[n-1];
        int result = 0;

        while(l<=r){
            if(lmax<=rmax){
                result+=Math.max(lmax-height[l], 0);
                lmax=Math.max(lmax, height[l]);
                l++;
            } else {
                result+=Math.max(rmax-height[r], 0);
                rmax=Math.max(rmax, height[r]);
                r--;
            }
        }

        return result;
    }



    // 空间法
    // 1ms Beats 66.99%
    public static int trap(int[] height) {
        int n = height.length;
        if(n <= 2){
            return 0;
        } 

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = height[0];
        for(int i=1; i<n; i++){
            lmax[i]=Math.max(height[i], lmax[i-1]);
        }

        rmax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rmax[i]=Math.max(height[i], rmax[i+1]);
        }

        int result=0;
        for(int i=1; i<n-1; i++){
            result += Math.max(Math.min(lmax[i], rmax[i])-height[i], 0); 
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }
}
