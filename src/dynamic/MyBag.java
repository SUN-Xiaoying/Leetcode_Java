package dynamic;

public class MyBag {
    public static void main(String[] args) {
//        int[] capacity = {2,3,4,5};
//        int[] rocks = {1,2,4,4};
//        int additionalRocks = 2;

        int[] capacity = {91,54,63,99,24,45,78};
        int[] rocks = {35,32,45,98,6,1,25};
        int additionalRocks = 17;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        return process(capacity, rocks, 0, 0, additionalRocks);
    }

    // Recursive: Time Limit Exceeded
    // The same way of Arrays.sort()
    public static int process(int[] capacity, int[] rocks, int index, int fullBags, int leftRocks){
        if(leftRocks <= 0 || index > capacity.length-1){
            return fullBags;
        }

        // Don't take current
        int p1 = process(capacity, rocks, index+1, fullBags, leftRocks);

        // Take current
        int leftover = leftRocks - capacity[index] + rocks[index];
        int p2 =0;

        if(leftover<0){
            p2 = process(capacity, rocks, index+1, fullBags, leftover);
        } else{
            p2 =  process(capacity, rocks, index+1, fullBags+1, leftover);
        }

        return Math.max(p1, p2);
    }

    // Greedy Algorithms

}
