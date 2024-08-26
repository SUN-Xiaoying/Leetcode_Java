package twopointer;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int result=0, n=height.length;
        int l=0, r=n-1;

        while(l<r){
            result = Math.max(result, Math.min(height[l], height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            } else {
                r--;
            }
        }

        return result;
    }


    // 55 / 62 testcases passed, Timeout Limit
    // Brutal!
    public static int mine(int[] height) {
        int result=0, n=height.length;

        for(int i=0; i<=n-1; i++){
            for(int j=n-1; j>i; j--){
                result = Math.max(result, Math.min(height[i], height[j])*(j-i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        // Output: 49

        System.out.println(maxArea(height));
    }


}
