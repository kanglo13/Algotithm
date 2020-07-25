package search.dfs;

public class IslandPerimeter {
    private int m;
    private int n;
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int islandPerimeter(int[][]grid){
        if (grid == null || grid.length ==0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (grid[i][j] == 1)
                    return dfs(grid,i,j);
            }
        }
        return 0;

    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n)
            return 1;
        if (grid[r][c] == 0)
            return 1;
        if (grid[r][c] != 1)
            return 0;
        grid[r][c] = 2;
        int perimeter = 0;
        for (int[]d : direction){
            perimeter += dfs(grid,r+d[0],c+d[1]);
        }
        return perimeter;
    }

}
