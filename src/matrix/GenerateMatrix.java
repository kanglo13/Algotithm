package matrix;

public class GenerateMatrix {
    public int[][]generateMatrix(int n){
        int[][]result = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        int index = 0;
        while (r1 <= r2 && c1 <= c2 && index < n*n){
            for (int i = c1;i <= c2;i++)
                result[r1][i] = index++;
            for (int i = r1+1;i <= r2;i++)
                result[i][c2] = index++;
            if (c1 != c2){
                for (int i = c2-1;i >= c1;i--)
                    result[r2][i] = index++;
            }
            if (r1 != r2)
                for (int i = r2-1;i > r1;i--)
                    result[i][c1] = index++;
            r1++;r2--;c1++;c2--;
        }
        return result;
    }
}
