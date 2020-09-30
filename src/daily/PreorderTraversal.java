package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-09-2020/9/29 15:40
 */
public class PreorderTraversal {
    public List<Integer>preorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            while (size-- > 0){
                TreeNode cur = stack.pop();
                result.add(cur.val);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return result;
    }
}
