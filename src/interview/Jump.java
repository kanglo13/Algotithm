package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/4 22:44
 */
public class Jump {
    public int jump(int[]nums){
        if (nums.length <= 1)
            return 0;
        int steps = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0;i < nums.length-1;i++){
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if (i == end){
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }
}
