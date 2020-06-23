package stackAndQueue.monotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[]heights){
        int n = heights.length;
        if (n == 0)
            return 0;
        else if (n == 1)
            return heights[0];
        int res = 0;
        int[]newHeights = new int[n+2];
        newHeights[0] = 0;
        System.arraycopy(heights,0,newHeights,1,n);
        newHeights[n+1] = 0;
        n += 2;
        Deque<Integer>stack = new ArrayDeque<>(n);
        stack.addLast(0);
        for (int i = 1;i < n;i++){
            while (newHeights[i] < newHeights[stack.peekLast()]){
                int curHeight = newHeights[stack.pollLast()];
                int curWidth = i - stack.peekLast()-1;
                res = Math.max(res,curWidth*curHeight);
            }
            stack.addLast(i);
        }
        return res;
    }
}
