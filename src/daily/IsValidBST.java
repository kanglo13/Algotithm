package daily;

public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
