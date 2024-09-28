package greedy.mycanlender;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/my-calendar-ii/description/
*/
public class MyCalendarII {

    PriorityQueue<Integer> heap;

    public MyCalendarII() {
        heap = new PriorityQueue<Integer>();
    }
    
    public boolean book(int start, int end) {
        while(!heap.isEmpty() && heap.peek()<=start){
            heap.poll();
        }

        if(heap.size()>=3){
            return false;
        } else {
            heap.add(end);
            return true;
        }
    }
}
