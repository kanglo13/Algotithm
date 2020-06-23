package daily;


import java.util.Map;
//类似于二叉树的最大直径
public class MaxPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = Math.max(root.val,Math.max(root.val+right,root.val+left));
        max = Math.max(max,Math.max(temp,root.val+left+right));
        return Math.max(root.val,Math.max(root.val+left,root.val+right));
    }
}
