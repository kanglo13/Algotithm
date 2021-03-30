package daily;

/**
 * @author kanglo
 * @create 2021-03-2021/3/30 21:40
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][]matrix,int target){
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while (r <= m -1 && c >= 0){
            if (target == matrix[r][c])
                return true;
            else if (target < matrix[r][c])
                c--;
            else r++;
        }
        return false;
    }
}
