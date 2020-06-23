package stackAndQueue.monotonicQueue;

import java.util.Stack;

public class Trap {
    public int trap(int[]height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0;
        Stack<Integer>stack = new Stack<>();
        for (int i = 0;i < height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIndex]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    int stackTop = stack.peek();
                    res += (Math.min(height[stackTop],height[i]) - height[curIndex]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return res;
    }

}
