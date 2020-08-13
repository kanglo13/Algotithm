package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>>levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer>list = new ArrayList<>();
            while (size-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (list.size() > 0)
                result.add(list);
        }
        return result;
    }
    public List<List<Integer>>levelOrders(TreeNode root){
        List<List<Integer>>result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>list = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            if (list.size() > 0)
                result.add(list);
        }
        return result;
    }
}
