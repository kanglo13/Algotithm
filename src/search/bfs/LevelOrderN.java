package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderN {
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                Node t = queue.poll();
                if (t == null)
                    continue;
                list.add(t.val);
                queue.addAll(t.children);
            }
            if (list.size() > 0)
                result.add(list);
        }
        return result;
    }
}
