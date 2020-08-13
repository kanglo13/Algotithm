package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[]pushed,int[]poped){
        Deque<Integer>stack = new ArrayDeque<>();
        int index = 0;
        for(int val : pushed){
            stack.push(val);
            while (index < poped.length && !stack.isEmpty() && stack.peek() == poped[index])
                stack.pop();
            index++;
        }
        return index == poped.length;
    }
}
