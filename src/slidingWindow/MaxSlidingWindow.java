package slidingWindow;

import java.util.*;

public class MaxSlidingWindow {
    public int[]maxSlidingWindow(int[]nums,int k){
        if (k > nums.length || k < 1)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[]res = new int[nums.length-k+1];
        int index = 0;
        for (int i = 0;i < k;i++){
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = 0,j = i + k;j < nums.length;i++,j++){
            queue.remove(nums[i]);
            queue.add(nums[j]);
            res[index++] = queue.peek();
        }
        return res;
    }
    public int[]maxSlidingWindowII(int[]nums,int k){
        int len = nums.length;
        if (len == 0)
            return new int[0];
        List<Integer>res = new ArrayList<>();
        Deque<Integer>deque = new ArrayDeque<>();

        for (int i = 0;i < len;i++){
            if (i >= k && i -k == deque.getFirst()){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]){
                deque.pollLast();
            }
            deque.add(i);
            if (i >= k-1){
                res.add(nums[deque.getFirst()]);
            }
        }
        int size = res.size();
        int[]result = new int[size];
        for (int i = 0;i < size;i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
