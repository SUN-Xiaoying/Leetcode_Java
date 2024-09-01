package dp.longestlength;

public class MaxLengthOfValidSub {
    // First Shot, 10ms Beats 25.00%
    // I'm so BAD ASS!
    public int maximumLength(int[] nums) {
        int length=Integer.MIN_VALUE, length1=0, length2=0;
        for(int num: nums){
            if(num%2==0){
                length1++;
            } else {
                length2++;
            }
        }
        length = Math.max(length1, length2);

        length1=0; 
        length2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == length1%2){
                length1++;
            } 
            if(nums[i]%2 != length2%2){
                length2++;
            }
        }
        length = Math.max(length, Math.max(length1, length2));

        return length;
    }
}
