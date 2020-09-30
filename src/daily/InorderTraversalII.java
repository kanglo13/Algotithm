package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-09-2020/9/29 15:50
 */
public class InorderTraversalII {
    public List<Integer>inorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            while (pre != null){
                stack.push(pre);
                pre = pre.left;
            }
            TreeNode cur = stack.pop();
            result.add(cur.val);
            pre = cur.right;
        }
        return result;
    }
}
