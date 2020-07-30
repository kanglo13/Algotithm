package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer>spiralOrder(int[][]matrix){
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length ==0)
            return result;
        int startx = 0, starty = 0;
        int endx = matrix[0].length-1,endy = matrix.length-1;
        while (startx < endx && starty < endy){
            for (int i = startx;i < endx;i++)
                result.add(matrix[starty][i]);

            for (int i = starty;i < endy;i++)
                result.add(matrix[i][endx]);

            for (int i = endx;i > startx;i--)
                result.add(matrix[endy][i]);

            for (int i = endy;i > starty;i--)
                result.add(matrix[i][startx]);

            startx++;
            endx--;
            starty++;
            endy--;

            if (starty == endy){
                while (startx <= endx)
                    result.add(matrix[starty][startx++]);
            }
            else{
                if (startx == endx)
                    while (starty <= endy)
                        result.add(matrix[starty++][startx]);
            }
            }

        return result;
    }
    public List<Integer>spiralOrderII(int[][]matrix){
        List<Integer>result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;
        int r1 = 0,r2 = matrix.length-1;
        int c1 = 0,c2 = matrix[0].length-1;
        while (r1 <= r2 && c1 <= c2){
            for (int i = c1;i <= c2;i++)
                result.add(matrix[r1][i]);
            for (int i = r1+1;i <= r2;i++)
                result.add(matrix[i][c2]);

            if (c1 != c2)
                for (int i = c2-1;i >= c1;i--)
                    result.add(matrix[r2][i]);
            if (r1 != r2)
                for (int i = r2 - 1;i > r1;i--)
                    result.add(matrix[i][c1]);
            r1++;r2--;c1++;c2--;
        }
        return result;
    }
}
