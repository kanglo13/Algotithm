package tree;

public class MaxAncestorDiff {
    int result = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root){
        if (root == null)
            return 0;
        maxAncestorDiff(root, root.val,root.val);
        return result;
    }
    private void maxAncestorDiff(TreeNode root,int max,int min){
        if (root == null)
            return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if (root.left == null && root.right == null)
            result = Math.max(result,max-min);
        maxAncestorDiff(root.left,max,min);
        maxAncestorDiff(root.right,max,min);
    }
}
