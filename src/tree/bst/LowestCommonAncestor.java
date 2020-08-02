package tree.bst;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root == null)
            return null;
        if ((p.val <= root.val && root.val <= q.val) || (q.val <= root.val && root.val <= p.val))
            return root;
        else if (root.val < p.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return lowestCommonAncestor(root.left,p,q);
    }
    public TreeNode lowestCommonAncestors(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || p == null || q == null)
            return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left == null ? right : right == null ? left : root;
    }
}
