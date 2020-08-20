package tree;

/**
 * @author kanglo
 * @create 2020-08-2020/8/18 17:05
 */
public class CountPairs {
    private int res;
    public int countPairs(TreeNode root,int distance){
        dfs(root,distance);
        return res;
    }
    private int[]dfs(TreeNode root,int distance){
        if (root == null)
            return new int[distance+1];
        int[]count = new int[distance+1];
        if (root.left == null && root.right == null){
            count[1] = 1;
            return count;
        }
        int[]left = dfs(root.left,distance);
        int[]right = dfs(root.right,distance);

        for (int i = 1;i <= distance;i++){
            for (int j = 1;j <= distance - i;j++){
                res += left[i] * right[j];
            }
        }
        for (int i = 2;i <= distance;i++){
            count[i] = left[i-1] + right[i-1];
        }
        return count;
    }
}
