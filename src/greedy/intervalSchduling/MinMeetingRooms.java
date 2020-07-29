package greedy.intervalSchduling;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals){
        if (intervals == null || intervals.length == 0)
            return 0;
        PriorityQueue<Integer>queue = new PriorityQueue<>();
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        queue.offer(intervals[0][1]);
        for (int i = 1;i < intervals.length;i++){
            int last = queue.peek();
            if (last <= intervals[i][0]){
                queue.poll();
                queue.offer(intervals[i][1]);
            }
            else {
                queue.offer(intervals[i][1]);
            }

        }
        return queue.size();
    }
}
