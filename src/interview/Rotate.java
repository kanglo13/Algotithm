package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/3 22:38
 */
public class Rotate {
    public void rotate(int[][]matrix){
        int n = matrix.length;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
