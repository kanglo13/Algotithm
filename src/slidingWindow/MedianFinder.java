package slidingWindow;

import java.util.PriorityQueue;

public class MedianFinder {
    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder(){
        count = 0;
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
    }
    public void addNum(int num){
        count += 1;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if ((count & 1) != 0){
            maxHeap.add(minHeap.poll());
        }
    }
    public double findMedian(){
        if ((count & 1) == 0)
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        else
            return (double)maxHeap.peek();
    }
}
