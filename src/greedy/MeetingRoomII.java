package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
 * https://leetcode.com/problems/meeting-rooms-iii/
 * https://www.youtube.com/watch?v=7lrD9J73QtE&list=PLvKfL6GtwDxwuyrpAJfU3HTnPZl4WnraE&index=89&ab_channel=%E5%B7%A6%E7%A8%8B%E4%BA%91
 * 56:53
*/
public class MeetingRoomII {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        int ans = 0;
        for(int[] meeting: meetings){
            while(!heap.isEmpty() && heap.peek()<=meeting[0]){
                heap.poll();
            }

            heap.add(meeting[1]);
            ans = Math.max(ans, heap.size());
        }

        return ans;
    }
}
