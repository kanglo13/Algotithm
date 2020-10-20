package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 20:26
 */
public class MaxAreaOfIsland {
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private int m;
    private int n;
    public int maxAreaOfIsland(int[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1){
                    result = Math.max(dfs(grid,i,j),result);
                }
            }
        }
        return result;
    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int island = 1;
        grid[r][c] = 0;
        for (int[]d : direction){
            island += dfs(grid,r+d[0],c+d[1]);
        }
        return island;
    }
}
