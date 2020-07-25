package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousions {
    public boolean isCousions(TreeNode root,int x,int y){
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            boolean xSeen = false;
            boolean ySeen = false;
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.val == x)
                    xSeen = true;
                if (node.val == y)
                    ySeen = true;
                if (node.left != null && node.right != null){
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))
                        return false;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }
            if (xSeen && ySeen)
                return true;
        }
        return false;
    }
}
