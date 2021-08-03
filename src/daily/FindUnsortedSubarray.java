package daily;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2021-08-2021/8/3 22:16
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[]nums){
        int n = nums.length;
        int[]array = nums.clone();
        Arrays.sort(array);
        int i = 0, j = n-1;
        while (i <= j && nums[i] == array[i])i++;
        while (i <= j && nums[j] == array[j]) j--;
        return j - i + 1;
    }
    public int findUnsortedSubarrayI(int[]nums){
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for (int i = 0;i < nums.length;i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length-1;i >= 0;i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r,stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}
