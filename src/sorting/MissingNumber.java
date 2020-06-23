package sorting;

public class MissingNumber {
    public int missingNumber(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;
        for (int num :nums)
            result ^= num;
        for (int i = 0;i <= nums.length;i++){
            result ^= i;
        }
        return result;
    }
}
