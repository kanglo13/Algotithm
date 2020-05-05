package dynamicProgramming.robber;

import java.util.HashMap;
import java.util.Map;

public class RobberIII {
    public int rob(TreeNode root){
        Map<TreeNode,Integer> map = new HashMap<>();
        if (map.containsKey(root))
            return map.get(root);
        int robed = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int unRob = rob(root.left) + rob(root.right);
        int result = Math.max(robed,unRob);
        map.put(root,result);
        return result;
    }
}
