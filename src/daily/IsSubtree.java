package daily;

public class IsSubtree {
    public boolean isSubtree(TreeNode s,TreeNode t){
        if (s == null)
            return false;
        if (isSameTree(s,t))
            return true;
        else
            return isSameTree(s.left,t) || isSameTree(s.right,t);
    }
    private boolean isSameTree(TreeNode s,TreeNode t){
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}
