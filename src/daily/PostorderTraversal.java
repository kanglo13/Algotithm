package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-09-2020/9/29 11:03
 */
public class PostorderTraversal {
    public List<Integer>postorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        stack.add(root);
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
        Collections.reverse(result);
        return result;
    }
}
