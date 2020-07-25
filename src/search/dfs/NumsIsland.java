package search.dfs;

public class NumsIsland {
    int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private int m;
    private int n;
    public int numsIslands(char[][]grid){
        m = grid.length;
        n = grid[0].length;
        int numsIsland = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == '1')
                    numsIsland += dfs(grid,i,j);
            }
        }
        return numsIsland;
    }
    private int dfs(char[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
            return 0;
        grid[r][c] = '0';
        int numsIsland = 1;
        for (int[]d : direction){
            numsIsland += dfs(grid,r+d[0],c+d[1]);
        }
        return numsIsland;
    }
}
