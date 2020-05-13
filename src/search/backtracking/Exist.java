package search.backtracking;

public class Exist {
    private int m;
    private int n;
    private final int[][]direction = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public boolean exist(char[][]board,String word){
        if (word == null || word.length() == 0)
            return true;
        else if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][]hasVisited = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (backtracking(board,hasVisited,word,0,i,j))
                    return true;
            }
        }
        return false;
    }
    private boolean backtracking(char[][]board,boolean[][]hasVisited,String word,int curLen,int r,int c){
        if (curLen == word.length())
            return true;
        if (r < 0 || r >= m || c < 0 ||c >= n || board[r][c] != word.charAt(curLen) || hasVisited[r][c])
            return false;
        hasVisited[r][c] = true;
        for (int[]d :direction){
            if (backtracking(board,hasVisited,word,curLen+1,r + d[0],c + d[1]))
                return true;
        }
        hasVisited[r][c] = false;
        return false;
    }
}
