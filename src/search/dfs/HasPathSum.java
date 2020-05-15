package search.dfs;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root,int sum){
        return dfs(root,sum);
    }
    private boolean dfs(TreeNode node, int sum){
        if (node == null)
            return false;
        sum -= node.val;
        if (isLeaf(node)){
            return sum == 0;
        }
        else {
            return dfs(node.left,sum) || dfs(node.right,sum);
        }
    }
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
