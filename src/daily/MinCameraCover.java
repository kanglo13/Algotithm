package daily;

/**
 * @author kanglo
 * @create 2020-09-2020/9/22 10:38
 */
public class MinCameraCover {
    private int res = 0;
    public int minCameraCover(TreeNode root){
        int last = preorder(root);
        if (last == 0)
            res++;
        return res;
    }
    private int preorder(TreeNode root){
        if (root == null)
            return 1;
        int left = preorder(root.left);
        int right = preorder(root.right);
        if (left == 0 || right == 0){
            res++;
            return 2;
        }
        if (left == 2 || right == 2){
            return 1;
        }
        return 0;
    }
}
