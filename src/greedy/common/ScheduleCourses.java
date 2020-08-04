package greedy.common;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class ScheduleCourses {
    public int ScheduleCourse(int[][]courses){
        Arrays.sort(courses,(o1, o2) -> o1[1]-o2[1]);
        PriorityQueue<Integer>heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        int time = 0;
        for (int[]course : courses){
            if (time + course[0] <= course[1]){
                heap.offer(course[0]);
                time += course[0];
            }
            else if (!heap.isEmpty() && heap.peek() > course[0]){
                time += course[0] - heap.poll();
                heap.offer(course[0]);
            }
        }
        return heap.size();
    }
}
