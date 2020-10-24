package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/21 15:30
 */
public class CanJumpII {
    public boolean canJump(int[]nums){
        int maxPos = 0;
        int end = 0;
        for (int i = 0;i < nums.length - 1;i++){
            maxPos = Math.max(maxPos,nums[i] + i);
            if (i == end)
                end = maxPos;
            if (i == nums.length-2)
                return end >= nums.length-1;
        }
        return false;
    }
    public int jump(int[]nums){
        int maxPos = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0;i < nums.length-1;i++){
            maxPos = Math.max(maxPos,nums[i]+i);
            if (i == end){
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
