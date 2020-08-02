package tree;

public class Flatten {
    TreeNode pre;
    public void flatten(TreeNode root){
        while (root != null){
            if (root.left == null){
                root = root.right;
            }
            else {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    public void flattenII(TreeNode root){
        while(root != null){
            if (root.left == null){
                root = root.right;
            }
            TreeNode pre = root.left;
            while(pre.right != null){
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left =  null;
            root = root.right;
        }
    }
    public void flatterIII(TreeNode root){
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if (pre != null)
            pre.right = root;
        pre = root;
        flatterIII(left);
        flatterIII(right);
    }

}
