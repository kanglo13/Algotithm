package search.dfs;

public class MaxAreaOfIsland {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int maxAreaOfIsland(int[][]grid){
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                maxArea = Math.max(maxArea,dfs(i,j,grid));
            }
        }
        return maxArea;
    }
    private int dfs(int r,int c,int[][]grid){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        int area = 1;
        grid[r][c] = 0;
        for (int[]d : direction){
            area += dfs(r + d[0],c + d[1],grid);
        }
        return area;
    }
}
