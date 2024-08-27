package binarysearch;

// https://leetcode.com/problems/koko-eating-bananas/description/
public class EatBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=0;

        for(int pile:piles){
            r = pile>r? pile : r;
        }

        int mid=0, ans=0;
       
        while(l<=r){
            mid = l+((r-l)>>1);
            if(eatUp(piles, mid) <= h){
                ans=mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
        }

        return ans;

    }

    public long eatUp(int[] piles, int k){
        long ans =0;
        for(int pile: piles){
            ans += (int)Math.ceil((double)pile/k);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
        System.out.println((int)Math.ceil(19/4));
        System.out.println((4+19-1)/4);
        
    }
}
