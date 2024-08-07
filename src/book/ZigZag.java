package book;

import java.util.*;
import java.lang.*;

public class ZigZag {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
            if(n==1){
                System.out.print(kb.nextInt());
                continue;
            } else {
                int a[] = new int[n];
                for(int i = 0; i < n; i++){
                    a[i] = kb.nextInt();
                }
                findZigZagSequence(a, n);
                System.out.println();
            }
        }
        kb.close();
    }

    public static void swap(int[]arr, int i, int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n>>1;

        swap(a, mid, n-1);

        int st = mid + 1;
        int ed = n - 2;
        while(st < ed){
            swap(a, st, ed);
            st++;
            ed--;
        }

        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
    }
}



