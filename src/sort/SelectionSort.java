package sort;

import java.io.*;

public class SelectionSort {
    public static void main(String[] args) throws IOException{
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        // selectionSort
        for(int i=0; i<size-1; i++){
            int minIndex = i;
            for(int j=i+1; j<size; j++){
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

        // output
        StringBuilder sb = new StringBuilder();
        for(int data: arr){
            sb.append(data).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
