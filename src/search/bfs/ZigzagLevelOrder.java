package search.bfs;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean reversed = false;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }

            if (list.size() > 0){
                if (reversed)
                    Collections.reverse(list);
                reversed = !reversed;
                result.add(list);
            }
        }
        return result;
    }
}
