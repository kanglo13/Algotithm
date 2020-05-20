package tree;

public class HasPath {
    private boolean hasPath(TreeNode root,int sum){
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPath(root.left,sum - root.val) || hasPath(root.right,sum - root.val);
    }
}
