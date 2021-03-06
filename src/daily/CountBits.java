package daily;

/**
 * @author kanglo
 * @create 2021-03-2021/3/3 11:20
 */
public class CountBits {
    public int[] countBits(int num){
        int[]result = new int[num+1];
        for (int i = 0;i <= num;i++){
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
