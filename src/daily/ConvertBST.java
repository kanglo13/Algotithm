package daily;

/**
 * @author kanglo
 * @create 2020-09-2020/9/21 8:34
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if (root == null)
            return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
