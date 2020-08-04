package tree.bst;

import java.util.Stack;

public class KthSmallest {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root,int k){
        dfs(root,k);
        return result;
    }
    private void dfs(TreeNode root,int k){
        if (root == null)
            return;
        dfs(root.left,k);
        if (++count == k){
            result = root.val;
            return;
        }
        dfs(root.right,k);
    }
}
