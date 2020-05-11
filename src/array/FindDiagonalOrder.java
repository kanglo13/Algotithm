package array;

public class FindDiagonalOrder {
    public int[]findDiagonalOrder(int[][]matrix){
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[]result = new int[m*n];
        int pos = 0;
            for (int j = 0;j < n;j++){
                for (int I = 0;I <= m + n -2;I++){
                    int i = I - j;
                    result[pos++] = matrix[i][j];
                }
            }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("test");
        System.out.println("test");
    }
}
