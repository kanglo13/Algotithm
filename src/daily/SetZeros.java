package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kanglo
 * @create 2021-03-2021/3/21 10:41
 */
public class SetZeros {
    public void setzeros(int[][]matrix){
        int m = matrix.length,n = matrix[0].length;
        Set<Integer>rowSet = new HashSet<>();
        Set<Integer>colSet = new HashSet<>();
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
