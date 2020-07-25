package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int[][]updateMatrix(int[][]matrix){
        Queue<int[]>queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (matrix[i][j] == 0)
                    queue.add(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        while (!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int[]d :direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR >= 0 && nextC >= 0 && nextR < m && nextC < n && matrix[nextR][nextC] == -1){
                    matrix[nextR][nextC] = matrix[r][c] + 1;
                    queue.add(new int[]{nextR,nextC});
                }
            }
        }
        return matrix;
    }
}
