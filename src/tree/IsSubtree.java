package tree;

public class IsSubtree {
    public boolean isSubTree(TreeNode s,TreeNode t){
        if (s == null)
            return false;
        return isSameTree(s,t) || isSubTree(s.left,t) || isSubTree(s.right,t);
    }
    private boolean isSameTree(TreeNode s,TreeNode t){
        if (s == null && t == null)
            return  true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}
