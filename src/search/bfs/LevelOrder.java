package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>>levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                list.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if (list.size() != 0)
                res.add(list);
        }
        return res;
    }
}
