package sliding;

// https://leetcode.com/problems/gas-station/description/
public class GasStation {

    public int mine(int[] gas, int[] cost) {
        int n =gas.length;
        int[] rest = new int[n];
        for(int i=0; i<n; i++){
            rest[i] = gas[i] - cost[i];
        }

        int sum = 0;
        for(int l=0, r=0, len=0; l<n; r++){
            sum += rest[r%n];

            // sum<0
            if(sum<0){
                l=r+1;
                len=0;
                sum=0;
            } else {
                len++;
                if(len==n){
                    return l;
                }
            }
        }

        return -1;

    }
}
