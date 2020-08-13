package stackAndQueue.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray {
    public int shortestSubarray(int[]A,int K){
        int n = A.length;
        int result = n + 1;
        int[]preSum = new int[n+1];
        Deque<Integer>queue = new ArrayDeque<>();
        for (int i = 0;i < n;i++){
            preSum[i+1] = preSum[i] + A[i];
        }
        for (int i = 0;i <= n;i++){
            while (!queue.isEmpty() && preSum[i] < preSum[queue.peekLast()])
                queue.pollLast();
            while (!queue.isEmpty() && preSum[i] - preSum[queue.peekFirst()] >= K){
                result = Math.min(result,i-queue.pollFirst());
            }
            queue.add(i);
        }
        return result == n+1 ? -1 : result;
    }
}
