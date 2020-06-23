package stackAndQueue.monotonicQueue;

import java.util.Stack;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[]nums){
        if (nums.length <= 1)
            return 0;
        int l = nums.length + 1,r = 0;
        Stack<Integer>stack = new Stack<>();
        for (int i = 0;i < nums.length;i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                l = Math.min(l,stack.pop());
            }
            stack.add(i);
        }
        stack.clear();;
        for (int i = nums.length-1;i >= 0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                r = Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r - 1 > 0 ? r - l + 1 : 0;
    }
}
