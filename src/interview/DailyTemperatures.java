package interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 17:21
 */
public class DailyTemperatures {
    public int[]dailyTemperaturs(int[]T){
        Deque<Integer>stack = new ArrayDeque<>();
        int[]result = new int[T.length];
        for (int i = T.length-1;i >= 0;i--){
            while (!stack.isEmpty() && stack.peek() <= T[i])
                stack.pop();
            result[i] = stack.isEmpty() ? 0 : (stack.peek()-i);
            stack.push(i);
        }
        return result;
    }
}
