package daily;

/**
 * @author kanglo
 * @create 2021-08-2021/8/7 10:31
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[]nums){
        int n = nums.length;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0)
                continue;
            int slow = i, fast = next(nums,i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums,fast)] > 0){
                if (slow == fast){
                    if (slow != next(nums,slow))
                        return true;
                    else
                        break;
                }
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums,add)] > 0){
                int temp = add;
                add = next(nums,add);
                nums[temp] = 0;
            }
        }
        return false;
    }
    private int next(int[] nums,int cur){
        int n= nums.length;
        return ((nums[cur] + cur) % n + n) % n;
    }
}
