package matrix;

public class FindDiagonalOrder {
    public int[]findDiagonalOrder(int[][]matrix){
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int row = matrix.length, col = matrix[0].length;
        int[]result = new int[row*col];
        int r = 0 , c = 0;
        for (int i = 0;i < result.length;i++){
            result[i] = matrix[r][c];
            if (((r+c)&1) == 0){
                if (c == col-1)
                    r++;
                else if (r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            }
            else {
                if (r == row-1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}
