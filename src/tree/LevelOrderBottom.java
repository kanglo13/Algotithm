package tree;

import search.backtracking.Trie;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>>levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size =  queue.size();
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
        Collections.reverse(result);
        return result;
    }
}
