package daily;

/**
 * @author kanglo
 * @create 2020-09-2020/9/13 10:20
 */
public class Exist {
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private int m;
    private int n;
    public boolean exist(char[][]board,String word){
        if (board == null || board.length == 0)
            return false;
        if (word == null || word.length() == 0)
            return true;
        m = board.length;
        n = board[0].length;
        boolean[][]hasVisited = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if (backtracking(board,word,i,j,0,hasVisited))
                    return true;
            }
        }
        return false;
    }
    private boolean backtracking(char[][]board,String word,int r,int c,int curLen,boolean[][]hasVisited){
        if (curLen == word.length())
            return true;
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(curLen) || hasVisited[r][c])
            return false;
        hasVisited[r][c] = true;
        for (int[] d : direction){
            if(backtracking(board,word,r+d[0],c+d[1],curLen+1,hasVisited))
                return true;
        }
        hasVisited[r][c] = false;
        return false;
    }
}
