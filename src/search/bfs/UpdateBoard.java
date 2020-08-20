package search.bfs;

/**
 * @author kanglo
 * @create 2020-08-2020/8/20 7:11
 */
public class UpdateBoard {
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    private int m;
    private int n;
    public char[][]updateBoard(char[][]board,int[]click){
        int r = click[0],c = click[1];
        m = board.length;
        n = board[0].length;
        if (board[r][c] == 'M'){
            board[r][c] = 'X';
        }
        else if (board[r][c] == 'E'){
            board[r][c] = 'B';
            dfs(board,r,c);

        }
        return board;
    }
    private void dfs(char[][]board,int r,int c){
        int count = 0;
        for (int[]d : direction){
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (isValid(nextR,nextC) && board[nextR][nextC] == 'M')
                count++;
        }
        if (count == 0){
            for (int[]d : direction){
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (isValid(nextR,nextC) && board[nextR][nextC] == 'E'){
                    board[nextR][nextC] = 'B';
                    dfs(board,nextR,nextC);
                }
            }
        }
        else {
            board[r][c] = (char)(count+48);
        }
    }
    private boolean isValid(int r,int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
