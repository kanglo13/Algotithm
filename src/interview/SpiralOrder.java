package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/22 21:34
 */
public class SpiralOrder {
    public List<Integer>spiralOrder(int[][]matrix){
        List<Integer>result = new ArrayList<>();
        int m = matrix.length,n = matrix[0].length;
        int r1 = 0,r2 = m-1;
        int c1 = 0,c2 = n - 1;
        while (r1 <= r2 && c1 <= c2){
            for (int i = c1;i <= c2;i++)
                result.add(matrix[r1][i]);
            for (int i = r1+1;i <= r2;i++)
                result.add(matrix[i][c2]);
            if (r1 != r2)
                for (int i = c2-1;i >= c1;i--)
                    result.add(matrix[r2][i]);
            if (c1 != c2)
                for (int i = r2-1;i > r1;i--)
                    result.add(matrix[i][c1]);
            r1++;r2--;c1++;c2--;
        }
        return result;
    }
}
