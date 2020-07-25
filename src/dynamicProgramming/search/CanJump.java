package dynamicProgramming.search;

public class CanJump {
    public boolean canjump(int[] nums){
        int end = 0;
        int maxPosition = 0;
        for (int i = 0;i < nums.length - 1;i++){
            maxPosition = Math.max(maxPosition,nums[i] + i);
            if (i == end){
                end = maxPosition;
            }
            if (i == nums.length - 2){
                return end >= nums.length -1;
            }
        }
        return false;
    }
}
