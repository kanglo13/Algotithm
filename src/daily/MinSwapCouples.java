package daily;

/**
 * @author kanglo
 * @create 2021-02-2021/2/14 11:01
 */
public class MinSwapCouples {
    public int minSwapCouples(int[]row){
        int n = row.length;
        int result = 0;
        int[]rowIndex = new int[n];
        for (int i = 0;i < n;i++){
            rowIndex[row[i]] = i;
        }
        for (int i = 0;i < n;i += 2){
            int next = row[i] ^ 1;
            if (next == row[i+1])
                continue;
            int swapIndex = rowIndex[next];
            rowIndex[row[i+1]] = swapIndex;
            row[swapIndex] = row[i+1];
            result++;
        }
        return result;
    }
}
