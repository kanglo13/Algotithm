package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer>preorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode>stack = new Stack<>() ;
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            while (size-- > 0){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);

            }
        }
        return result;

    }
}
