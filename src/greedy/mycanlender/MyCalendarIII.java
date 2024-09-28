package greedy.mycanlender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/my-calendar-iii/
 */
public class MyCalendarIII {
    private List<int[]> events;
    private List<int[]> overlaps;

    public MyCalendarIII() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
        for (int[] event : events) {
            int overlapStart = Math.max(event[0], startTime);
            int overlapEnd = Math.min(event[1], endTime);
            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
                
            }
        }
        
        Collections.sort(overlaps, (a,b)-> a[0] - b[0]);
        int ans=0;
        for(int[] overlap: overlaps){
            if(Math.max(startTime, overlap[0])<Math.min(endTime, overlap[1])){
                ans++;
            }
        }

        events.add(new int[]{startTime, endTime});

        return ans;
    }
}
