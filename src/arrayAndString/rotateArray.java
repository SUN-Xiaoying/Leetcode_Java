package arrayAndString;

import java.util.Arrays;
import java.util.List;

public class rotateArray {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        int i=0;
        // odd or even?
        while(i<k){
            nums[i] = nums[i]^nums[k+i];
            nums[k+i] = nums[i]^nums[k+i];
            nums[i] = nums[i]^nums[k+i];
            i++;
        }
    }
}
