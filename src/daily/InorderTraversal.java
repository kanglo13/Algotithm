package daily;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-09-2020/9/14 16:53
 */
public class InorderTraversal {
    public List<Integer>inorderTravesal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
        }
        return result;
    }
}
