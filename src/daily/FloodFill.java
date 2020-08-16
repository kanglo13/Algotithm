package daily;

public class FloodFill {
    private int[][]direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private int m;
    private int n;
    private int oldColor;
    private int newColor;
    public int[][]floodFill(int[][]image,int sr,int sc,int newColor){
        m = image.length;
        n = image[0].length;
        oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image;
        this.newColor = newColor;
        dfs(image,sr,sc);
        return image;
    }
    private void dfs(int[][]image,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != oldColor)
            return;
        image[r][c] = newColor;
        for (int[]d : direction){
            dfs(image,r+d[0],c+d[1]);
        }

    }
}
