package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/4 22:36
 */
public class CanJump {
    private boolean canJump(int[]nums){
        if (nums.length == 1)
            return true;
        int end = 0,maxPosition = 0;
        for (int i = 0;i < nums.length;i++){
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if (i == end)
                end = maxPosition;
            if (i == nums.length - 2)
                return end >= nums.length - 1;
        }
        return false;
    }
}
