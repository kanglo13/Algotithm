package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 16:48
 */
public class KthSmallest {
    public int KthSmallest(int[][]matrix,int k){
        if (matrix == null || matrix.length == 0)
            return -1;
        int n = matrix.length-1;
        int left = matrix[0][0],right = matrix[n][n];
        while (left < right){
            int mid = (left + right) >>> 1;
            int count = countLess(matrix,mid,n);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    private int countLess(int[][]matrix,int mid,int n){
        int count = 0;
        int x = 0,y = n;
        while (x <= n && y >= 0){
            if (matrix[y][x] <= mid){
                count += y+1;
                x++;
            }
            else
                y--;
        }
        return count;
    }
}
