package stackAndQueue.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[]nums,int k){
        int n = nums.length;
        if (n == 0)
            return new int[0];
        int[]res = new int[n-k+1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0;i < n;i++){
            if (i >= k && i-k == deque.getFirst())
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.pollLast();
            deque.push(i);
            if (i >= k-1)
                res[index++] = nums[deque.getFirst()];
        }
        return res;
    }
}
