package unionFind;

public class Solve {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public void solve(char[][]board){
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        m = board.length;
        n = board[0].length;
        for (int i = 0;i < m;i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }
        for (int j = 0;j < n;j++){
            dfs(0,j,board);
            dfs(m-1,j,board);
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }
    private void dfs(int r,int c,char[][]board){
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] !='O')
            return;
        board[r][c] = 'T';
        for (int[]d :direction){
            dfs(r+d[0],c+d[1],board);
        }
    }
}
