package tree.bst;

public class GetMinimumDifference {
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root){
        if (root == null)
            return;
        dfs(root.left);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null)
            left = root.val - root.left.val;
        if (root.right != null)
            right = root.right.val - root.val;
        result = Math.min(result,Math.min(left,right));
        dfs(root.right);
    }
}
