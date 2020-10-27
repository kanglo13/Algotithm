package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/27 19:40
 */
public class PreorderTraversalII {
    public List<Integer>preorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode>stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            while (size-- > 0){
                TreeNode cur = stack.poll();
                result.add(cur.val);
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left!= null)
                    stack.push(cur.left);
            }
        }
        return result;
    }
}
