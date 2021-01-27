package daily;

/**
 * @author kanglo
 * @create 2021-01-2021/1/24 10:43
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[]nums){
        if (nums.length == 0)
            return 0;
        int cur = 0;
        int max = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] > nums[i-1]){
                max = Math.max(max,i-cur+1);
            }
            else {
                cur = i;
            }
        }
        return max;
    }
}
