package tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer>inorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty()|| cur != null){
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
