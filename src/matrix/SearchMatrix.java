package matrix;

public class SearchMatrix {
    public boolean searchMatrix(int[][]matrix,int target){
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length-1,n = matrix[0].length - 1;
        int r = 0 , c = n;
        while (r <= m && c >= 0){
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                c--;
            else
                r++;
        }
        return false;
    }
}
