package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/7 10:49
 */
public class SortColors {
    public void sortColors(int[]nums){
        int zeros = 0,ones = 0,twos = 0;
        for (int num : nums){
            if (num == 0)
                zeros++;
            else if (num == 1)
                ones++;
            else
                twos++;
        }
        for (int i = 0;i < zeros;i++)
            nums[i] = 0;
        for (int i = zeros;i < zeros + ones;i++)
            nums[i] = 1;
        for (int i = zeros+ones;i < nums.length;i++){
            nums[i] = 2;
        }
    }
}
