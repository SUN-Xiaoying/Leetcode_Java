package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//给你一个n代表有一个长度为n的有序数组，然后给你一个k，你需要判断这个k是否在数组里面，
//        如果存在就返回这个数从左往右第一次出现位置的下标，如果不存在输出-1

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int size = Integer.parseInt(info[0]);
        int target = Integer.parseInt(info[1]);
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        // BinarySearch
        int left = 0;
        int right = size - 1;
        int mid;
        int flag = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                while (mid >= 0 && arr[mid - 1] == target) {
                    mid--;
                }
                flag = mid;
                break;
            }
        }

        // output
        System.out.println(flag);
    }
}
