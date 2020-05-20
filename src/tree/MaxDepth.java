package tree;

import java.util.Map;

public class MaxDepth {
    public int maxDepth(TreeNode root){
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
