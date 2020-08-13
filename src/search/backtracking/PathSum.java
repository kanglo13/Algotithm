package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>>pathSum(TreeNode root,int sum){
        List<List<Integer>>paths = new ArrayList<>();
        if (root == null)
            return paths;
        List<Integer>tempPath = new ArrayList<>();
        backtracking(root,paths,tempPath,sum);
        return paths;

    }
    private void backtracking(TreeNode node,List<List<Integer>>paths,List<Integer>tempPath,int sum){
        if (node == null)
            return;
        tempPath.add(node.val);
        if (node.left == null && node.right == null && sum == node.val){
            paths.add(new ArrayList<>(tempPath));
        }
        backtracking(node.left,paths,tempPath,sum- node.val);
        backtracking(node.right,paths,tempPath,sum- node.val);
        tempPath.remove(tempPath.size()-1);
    }
}
