package search.dfs;

public class UpdateMatrix {
    private int m;
    private int n;
    private int[][]direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int updateMatrix(int[][]matrix){
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == 1){

                }
            }
        }
    }
    private int  dfs(int[][]matrix,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n)
            return 0;
        int distance = 1;
        if (matrix[r][c] == 0)
            return distance;

    }
}
