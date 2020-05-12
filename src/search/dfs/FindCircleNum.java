package search.dfs;

public class FindCircleNum {
    private int n;
    public int findCircleNum(int[][]M){
        int n = M.length;
        int circleNum = 0;
        boolean[]hasVisited = new boolean[n];
        for (int i = 0;i < n;i++){
            if (!hasVisited[i]){
                circleNum++;
                dfs(i,hasVisited,M);
            }
        }
        return circleNum;
    }
    private void dfs(int i,boolean[]hasVisited,int[][]M){
        hasVisited[i] = true;
        for (int k = 0;k < n;k++){
            if (M[i][k] == 1 && !hasVisited[k])
                dfs(k,hasVisited,M);
        }
    }
}
