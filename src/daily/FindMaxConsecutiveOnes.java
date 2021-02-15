package daily;

/**
 * @author kanglo
 * @create 2021-02-2021/2/15 9:26
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[]nums){
        int count = 0,result = 0;
        for (int num : nums) {
            if (num == 1)
                count++;
            else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(count,result);
        return result;
    }
}
