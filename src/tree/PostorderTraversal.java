package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer>postorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            while (size-- > 0){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
        }
        Collections.reverse(result);;
        return result;
    }
}
