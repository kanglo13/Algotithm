package daily;

public class SingleNumbers {
    public int singleNumbers(int[]nums){
        int result = 0;
        for (int num : nums){
            result ^= num;
        }
        return result;
    }
}
