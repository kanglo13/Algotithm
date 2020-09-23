package daily;

/**
 * @author kanglo
 * @create 2020-09-2020/9/23 18:28
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}
