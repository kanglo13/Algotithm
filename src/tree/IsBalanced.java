package tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root){
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode node){
        return node == null ? 0 : Math.max(depth(node.left),depth(node.right))+1;
    }
}
