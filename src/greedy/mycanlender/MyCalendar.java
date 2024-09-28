package greedy.mycanlender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/my-calendar-i/description/
 */
public class MyCalendar {
    // 意不意外?
    private List<int[]> events;

    List<List<Integer>> list;

    public MyCalendar() {
        list = new ArrayList<>();
        events = new ArrayList<>();
    }

    // ChatGPT, 62ms Beats 34.35%
    public boolean book(int start, int end) {
        for (int[] event : events) {
            if (Math.max(event[0], start) < Math.min(event[1], end)) {
                return false;
            }
        }
        events.add(new int[]{start, end});
        return true;
    }

    /*
     * Xiao conquests Greedy
     * 136ms Beats 11.66%
    */
    public boolean mine(int start, int end) {
        for(List<Integer> event: list){
            boolean first = (end >= event.get(0));
            boolean second = (start>= event.get(1));
            if(first && second){
                return false;
            }
        }
        list.add(Arrays.asList(start, end));
        return true;
    }
}
