package search.dfs;

public class NumIslands {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int numIslands = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == '1'){
                    dfs(i,j,grid);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void dfs(int r,int c,char[][]grid){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for (int[]d : direction){
            dfs(r+d[0],c+d[1],grid);
        }
    }
}
