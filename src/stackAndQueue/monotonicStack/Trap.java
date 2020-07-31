package stackAndQueue.monotonicStack;

import java.util.Stack;

public class Trap {
    public int trap(int[]heights){
        if (heights == null || heights.length == 0)
            return 0;
        int result = 0;
        Stack<Integer>stack = new Stack<>();
        for (int i = 0;i < heights.length;i++){
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                int curIndex = stack.pop();
                while (!stack.isEmpty() && heights[curIndex] == heights[stack.peek()])
                    stack.pop();
                if (!stack.isEmpty()){
                    int stackTop = stack.peek();
                    result += (Math.min(heights[i],heights[stackTop]) - heights[curIndex]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return result;
    }
}
