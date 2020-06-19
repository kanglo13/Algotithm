package slidingWindow;

public class MinSubArrayLen {
    public int minSubArrayLen(int s,int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0,right = 0;
        int sum = 0;
        int minLen = nums.length + 1;
        while (right < nums.length){
            sum += nums[right];
            while (sum >= s){
                if (right - left + 1 < minLen){
                    minLen = right - left + 1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == nums.length+1 ? 0 : minLen;
    }
}
