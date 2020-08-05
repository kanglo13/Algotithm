package daily;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    private Map<TreeNode,Integer>memo = new HashMap<>();
    public int rob(TreeNode root){
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int robbed = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int unRobbed = rob(root.left) + rob(root.right);
        int result = Math.max(robbed,unRobbed);
        memo.put(root,result);
        return result;
    }
}
