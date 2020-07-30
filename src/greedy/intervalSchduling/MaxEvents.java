package greedy.intervalSchduling;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {
    public int maxEvents(int[][]events){
      int result = 0,i = 0,last = 1;
      int n = events.length;
      Arrays.sort(events,(o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer>heap = new PriorityQueue<>();
        while (i < n || !heap.isEmpty()){
            while (i < n && events[i][0] == last){
                heap.offer(events[i++][1]);
            }
            while (!heap.isEmpty() && heap.peek() < last)
                heap.poll();
            if (!heap.isEmpty()){
                heap.poll();
                result++;
            }
            last++;
        }
        return result;
    }
}
