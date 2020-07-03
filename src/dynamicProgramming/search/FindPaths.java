package dynamicProgramming.search;

import java.util.HashMap;
import java.util.Map;

public class FindPaths {
    private final int mod = 1000000007;
    private final int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int findPaths(int m,int n, int N, int i, int j){
        if (N == 0)
            return 0;
        int[][]dp = new int[m][n];
        for (int k = 0;k < N;k++){
            int[][]temp = new int[m][n];
            for (int x = 0;x < m;x++){
                for (int y = 0;y < n;y++){
                    for (int[]d : direction){
                        if (x+d[0] < 0 || x +  d[0] >= m || y + d[1] < 0 || y + d[1] >= n)
                            temp[x][y]++;
                        else
                            temp[x][y] = ( temp[x][y] + dp[x+d[0]][y+d[1]]) % mod;
                    }
                }
            }
            dp = temp;
        }
        return dp[i][j];
    }
    private Map<String,Integer>map = new HashMap<>();
    public int findPathsII(int m,int n, int N, int i, int j){
        return dfs(m,n,N,i,j);
    }
    private int dfs(int m,int n, int N,int i,int j){
        if (N < 0)
            return 0;
        if (N < i + 1 && N < j+1 && N < m-i && N < n -j)
            return 0;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;
        if (map.containsKey(i+","+j+","+N))
            return map.get(i+","+j+","+N);
        int count = 0;
        for (int[]d : direction){
            count += dfs(m,n,N,i+d[0],j+d[1]);
            count %= mod;
        }
        map.put(i+","+j+","+N,count);
        return count;

    }
}
