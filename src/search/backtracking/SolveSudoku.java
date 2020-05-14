package search.backtracking;

public class SolveSudoku {
    private boolean[][]rowUsed = new boolean[9][10];
    private boolean[][]colUsed = new boolean[9][10];
    private boolean[][]cubeUsed = new boolean[9][10];
    private char[][]board;
    public void solveSudoku(char[][]board){
        this.board = board;
        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                rowUsed[i][num] = true;
                colUsed[j][num] = true;
                cubeUsed[cubeNum(i,j)][num] = true;
            }
        }
        backtracking(0,0);


    }
    private boolean backtracking(int row,int col){
        while (row < 9 && board[row][col] != '.'){
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }
        if (row == 9)
            return true;
        for (int num = 1;num <= 9;num++){
            if (rowUsed[row][num] || colUsed[col][num] || cubeUsed[cubeNum(row,col)][num])
                continue;
            rowUsed[row][num] = colUsed[col][num] = cubeUsed[cubeNum(row,col)][num] = true;
            board[row][col] = (char)(num + '0');
            if (backtracking(row,col))
                return true;
            board[row][col] = '.';
            rowUsed[row][num] = colUsed[col][num] = cubeUsed[cubeNum(row,col)][num] = false;
        }
        return false;

    }
    private int cubeNum(int i,int j){
        int r = i / 3;
        int c = j / 3;
        return r * 3 + c;
    }
}
