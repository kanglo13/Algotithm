package tree;

import java.util.*;

public class RightSideView {
    public List<Integer>rightSideView(TreeNode root){
        List<Integer>result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (size == 0)
                    result.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}
