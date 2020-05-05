package dynamicProgramming.robber;

public class RobberII {
    public int rob(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    private int rob(int[]nums,int first,int last){
        int pre1 = 0, pre2 = 0;
        for (int i = first;i <= last;i++){
            int cur = Math.max(pre1,pre2+ nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
