package daily;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-03-2021/3/6 17:16
 */
public class NextGreaterElements {
    public int[]nextGreaterElements(int[]nums){
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        int n = nums.length;
        int[]result = new int[n];
        Arrays.fill(result,-1);
        for (int i = 0;i < 2*n;i++){
            while (!stack.isEmpty() && nums[i%n] > stack.peekLast()){
                int u = stack.pollLast();
                result[u] = nums[i%n];
            }
            stack.addLast(i%n);
        }
        return result;
    }
}
