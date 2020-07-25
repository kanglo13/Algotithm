package search.dfs;

public class MaxAreaOfIslandII {
    private int m;
    private int n;
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int maxAreaOfIsland(int[][]grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1)
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int area = 1;
        for (int[]d : direction){
            area += dfs(grid,r+d[0],c+d[1]);
        }
        return area;
    }
}
