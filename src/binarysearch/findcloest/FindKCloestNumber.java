package binarysearch.findcloest;

import java.util.ArrayList;
import java.util.List;

public class FindKCloestNumber {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Step 1: Find the closest index to x using binary search
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Step 2: Use two pointers to find the k closest elements
        left = right - 1;
        
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        
        // Step 3: Collect the result
        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }

    // 65 / 70 testcases passed
    // I'm PROUND of you
    public static List<Integer> mine(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        
        int n=arr.length;
        if(x<=arr[0]){
            return list.subList(0, k);
        }
        if(x>=arr[n-1]){
            return list.subList(n-k, n);
        }

        int l=0, r=n-1, mid=0;
        while(l<r){
            mid=l+((r-l)>>1);

            if(arr[mid]==x){
                break;
            }
            if(arr[mid]>x){
                r=mid;
            } else {
                l=mid+1;
            }
        }

        l= mid-1;
        r= mid;
        List<Integer> result = new ArrayList<Integer>();
        while(k--<0){

            if(l<0){
                r++;
            }else if(r>n-1){
                l--;
            }else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)){
                l--;
            } else {
                r++;
            }
        }

        for(int i=l; i<r+1; i++){
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3};
        int k = 1, x = 2;
        // [1,2,3,4]

        // int[] arr = {1,2,3,4,5};
        // int k = 4, x = 5;

        List<Integer> result = findClosestElements(arr, k, x);

        for(int num: result){
            System.out.println(num);
        }
    }
}
