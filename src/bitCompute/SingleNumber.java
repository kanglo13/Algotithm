package bitCompute;

public class SingleNumber {
    public int[] singleNumber(int[]nums){
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        int[]result = new int[2];
        diff &= -diff;
        for (int num : nums){
            if ((num & diff) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
    }
}
