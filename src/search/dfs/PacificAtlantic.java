package search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][]matrix){
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ret;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0;i < m;i++){
            dfs(i,0,canReachP,matrix);
            dfs(i,n-1,canReachA,matrix);
        }
        for (int j = 0;j < n;j++){
            dfs(0,j,canReachP,matrix);
            dfs(m-1,j,canReachA,matrix);
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (canReachA[i][j] && canReachP[i][j]){
                    ret.add(Arrays.asList(i,j));
                }
            }
        }
        return ret;
    }
    private void dfs(int r,int c,boolean[][]canReach,int[][]matrix){
        if (canReach[r][c])
            return;
        canReach[r][c] = true;

        for (int[]d : direction){
            int nr = r + d[0],nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[r][c] > matrix[nr][nc])
                continue;
            dfs(nr,nc,canReach,matrix);
        }
    }
}
