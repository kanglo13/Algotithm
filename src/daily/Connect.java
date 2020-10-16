package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kanglo
 * @create 2020-10-2020/10/15 8:46
 */
public class Connect {
    public Node connect(Node root){
        if (root == null)
            return null;
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node pre = null;
            int size = queue.size();
            while (size-- >0){
                Node cur = queue.poll();
                if (pre != null)
                    pre.next = cur;
                pre = cur;
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        return root;
    }
}
