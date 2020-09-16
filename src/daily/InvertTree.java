package daily;

/**
 * @author kanglo
 * @create 2020-09-2020/9/16 9:22
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root){
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
